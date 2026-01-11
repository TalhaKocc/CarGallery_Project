package com.talhakoc.dto.employee.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateDto {

	@NotBlank(message = "Bu alan boş bırakılamaz")
	private String fullName;

	private String password;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	@Pattern(regexp = "^[0-9]{10,11}$", message = "Telefon numarası 10-11 hane olmalıdır")
	private String phoneNumber;
}
