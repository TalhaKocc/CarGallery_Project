package com.talhakoc.service.impl;

import java.util.List;

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

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {
	
	private final UserRepository userRepository;
	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;
	private final UserMapper userMapper;

	@Override
	public UserDto saveEmployee(EmployeeCreateDto employeeCreateDto) {

		User user = userMapper.toEntitiy(employeeCreateDto);
		userRepository.save(user);
		
		Employee employee = employeeMapper.toEmployee(employeeCreateDto);
		
		employee.setUser(user);
		employeeRepository.save(employee);
		
		return userMapper.toDto(user);
	}

	@Override
	public List<EmployeeDto> listAll() {

		List<Employee> employees = employeeRepository.findAll();
		return employeeMapper.toDtoList(employees);
	}

	@Override
	public UserDto updateEmployee(EmployeeUpdateDto employeeUpdateDto) {

		Employee employee = employeeRepository.findById(employeeUpdateDto.getId())
				.orElseThrow(() -> new RuntimeException("employe not found"));
		
		userMapper.updateUserFromDto(employeeUpdateDto, employee.getUser());
		userRepository.save(employee.getUser());
		
		employeeMapper.updateEmployeeFromDto(employeeUpdateDto, employee);
		employeeRepository.save(employee);
		
		return userMapper.toDto(employee.getUser());
	}

	@Override
	public void deleteEmployee(Long id) {
		
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Çalışan bulunamadı"));
		employeeRepository.delete(employee);
	}


}
