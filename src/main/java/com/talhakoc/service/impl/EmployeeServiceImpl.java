package com.talhakoc.service.impl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.talhakoc.dto.employee.request.EmployeeCreateDto;
import com.talhakoc.dto.employee.request.EmployeeUpdateDto;
import com.talhakoc.dto.employee.response.EmployeeDto;
import com.talhakoc.dto.user.response.UserDto;
import com.talhakoc.mapper.EmployeeMapper;
import com.talhakoc.mapper.UserMapper;
import com.talhakoc.model.Employee;
import com.talhakoc.model.User;
import com.talhakoc.repository.EmployeeRepository;
import com.talhakoc.repository.UserRepository;
import com.talhakoc.service.IEmployeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {
	
	private final UserRepository userRepository;
	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;
	private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
    public UserDto saveEmployee(EmployeeCreateDto employeeCreateDto) {

        log.info("Yeni kullanıcı emaili: {}", employeeCreateDto.getEmail());

        if(userRepository.findByEmail(employeeCreateDto.getEmail()).isPresent()) {
            log.warn("Email already exists: {}", employeeCreateDto.getEmail());
            throw new RuntimeException("Bu Email Adresi Zaten Kullanılıyor" + employeeCreateDto.getEmail());
        }

		User user = userMapper.toEntity(employeeCreateDto);

        user.setPassword(passwordEncoder.encode(employeeCreateDto.getPassword()));
        user.setEnabled(true);

        userRepository.save(user);
		log.debug("User saved with ID: {}", user.getId());

		Employee employee = employeeMapper.toEntity(employeeCreateDto);
        employee.setUser(user);

        employeeRepository.save(employee);
		log.info("Employee saved with ID: {}", employee.getId());

		return userMapper.toDto(user);
	}

	@Override
    @Transactional
    public List<EmployeeDto> listAll() {
        log.info("Fetching all employees");
		List<Employee> employees = employeeRepository.findAll();
		return employeeMapper.toDtoList(employees);
	}

	@Override
	@Transactional
    public UserDto updateEmployee(EmployeeUpdateDto employeeUpdateDto) {

        log.info("Updating employee with ID: {}", employeeUpdateDto.getId());

		Employee employee = employeeRepository.findById(employeeUpdateDto.getId())
				.orElseThrow(() -> new RuntimeException("employe not found"));

        if (!employee.getUser().getEmail().equals(employeeUpdateDto.getEmail())) {
            if (userRepository.findByEmail(employeeUpdateDto.getEmail()).isPresent()) {
                log.warn("Email already exists: {}", employeeUpdateDto.getEmail());
                throw new RuntimeException("Bu email adresi zaten kullanılıyor: " +  employeeUpdateDto.getEmail());
            }
        }

        String  encodePassword = null;

        if(employeeUpdateDto.getPassword() != null && !employeeUpdateDto.getPassword().isBlank()) {
            encodePassword = passwordEncoder.encode(employeeUpdateDto.getPassword());
            log.debug("Password will be updated for employee ID: {}", employeeUpdateDto.getId());
        }

		userMapper.updateUserFromDto(employeeUpdateDto, employee.getUser());

        if (encodePassword != null){
            employee.getUser().setPassword(encodePassword);
        }

        userRepository.save(employee.getUser());
		
		employeeMapper.updateEmployeeFromDto(employeeUpdateDto, employee);
		employeeRepository.save(employee);

        log.info("Employee updated successfully with ID: {}", employee.getId());

		return userMapper.toDto(employee.getUser());
	}

	@Override
	@Transactional
    public void deleteEmployee(Long id) {
		log.info("Deleting employee with ID: {}", id);

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Çalışan bulunamadı"));

        employeeRepository.delete(employee);
	    log.info("Employee deleted successfully with ID: {}", id);
    }


}
