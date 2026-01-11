package com.talhakoc.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.talhakoc.dto.employee.request.EmployeeUpdateSalaryDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
       return employeeRepository.findAll()
               .stream()
               .map(employeeMapper::toDto)
               .toList();
	}

	@Override
    @Transactional
    public EmployeeDto updateSalary(EmployeeUpdateSalaryDto employeeUpdateSalaryDto) {

        log.info("Updating employee with id: {}", employeeUpdateSalaryDto.getId());

        Employee employee = employeeRepository.findById(employeeUpdateSalaryDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeUpdateSalaryDto.getId()));

        if(employeeUpdateSalaryDto.getSalary().compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("Maaş pozitif olmalı");
        }

        employee.setSalary(employeeUpdateSalaryDto.getSalary());

        employeeRepository.save(employee);

        return employeeMapper.toDto(employee);
    }


    @Override
	@Transactional
    public UserDto updateEmployee(EmployeeUpdateDto employeeUpdateDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String currentUserEmail = authentication.getName();

        User user = userRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + currentUserEmail));

        Employee employee = employeeRepository.findByUserId(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + user.getId()));

        user.setFullName(employeeUpdateDto.getFullName());

        if(employeeUpdateDto.getPassword() != null && !employeeUpdateDto.getPassword().isBlank()) {
           user.setPassword(passwordEncoder.encode(employeeUpdateDto.getPassword()));
        }

        userRepository.save(user);
		
		employee.setPhoneNumber(employeeUpdateDto.getPhoneNumber());
		employeeRepository.save(employee);

        log.info("Employee updated successfully with ID: {}", employee.getId());

		return userMapper.toDto(employee.getUser());
	}

	@Override
	@Transactional
    public String deleteEmployee(Long id) {
		log.info("Deleting employee with ID: {}", id);

		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Çalışan bulunamadı"));

        employeeRepository.delete(employee);
	    log.info("Employee deleted successfully with ID: {}", id);
        return "User delete successfully" + id;
    }


}
