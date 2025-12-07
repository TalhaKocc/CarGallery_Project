package com.talhakoc.dto.employee.response;

import java.math.BigDecimal;

import com.talhakoc.dto.user.response.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private UserDto user;
	
	private BigDecimal salary;
	
	private String phoneNumber;
	
	
}
