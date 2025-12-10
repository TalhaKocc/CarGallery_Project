package com.talhakoc.service;

import java.util.List;

import com.talhakoc.dto.employee.request.EmployeeCreateDto;
import com.talhakoc.dto.employee.request.EmployeeUpdateDto;
import com.talhakoc.dto.employee.response.EmployeeDto;
import com.talhakoc.dto.user.response.UserDto;

public interface IEmployeeService {

	public UserDto saveEmployee(EmployeeCreateDto employeeCreateDto);

	public UserDto updateEmployee(EmployeeUpdateDto employeeUpdateDto);
	
	public List<EmployeeDto>listAll();
}
