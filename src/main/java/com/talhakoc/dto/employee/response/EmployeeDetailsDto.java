package com.talhakoc.dto.employee.response;

import com.talhakoc.dto.user.response.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDto {

	private UserDto user;
	
	private String phoneNumber;
}
