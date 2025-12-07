package com.talhakoc.dto.employee.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDto {

	private String fullName;
	
	private String email;
	
	private String password;
	
	private String phoneNumber;
	
	private BigDecimal salary;
}
