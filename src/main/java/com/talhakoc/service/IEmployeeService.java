package com.talhakoc.service;

import java.util.List;

import com.talhakoc.dto.employee.request.EmployeeCreateDto;
import com.talhakoc.dto.employee.request.EmployeeUpdateDto;
import com.talhakoc.dto.employee.request.EmployeeUpdateSalaryDto;
import com.talhakoc.dto.employee.response.EmployeeDto;
import com.talhakoc.dto.user.response.UserDto;

public interface IEmployeeService {

	 UserDto saveEmployee(EmployeeCreateDto employeeCreateDto);

	 UserDto updateEmployee(EmployeeUpdateDto employeeUpdateDto);
	
	 EmployeeDto updateSalary(EmployeeUpdateSalaryDto employeeUpdateSalaryDto);

     List<EmployeeDto>listAll();
	
	 String deleteEmployee(Long id);
}
