package com.talhakoc.dto.employee.request;

import java.math.BigDecimal;

import com.talhakoc.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDto {

	@NotBlank(message = "İsim alanı boş bırakılamaz")
	private String fullName;
	
	@Email(message = "Lütfen email formatında giriniz")
	@NotBlank(message = "bu alan boş bırakılamaz")
	private String email;
	
	@NotBlank(message = "Lütfen şifre giriniz")
	private String password;
	
	@NotNull(message = "Bu alan boş bırakılamaz")
	private Role role;
	
	@NotBlank(message = "Lütfen telefon numarası giriniz")
	@Pattern(regexp = "^[0-9]{10,11}$", message = "Telefon numarası 10-11 hane olmalıdır")
	private String phoneNumber;
	
	@Positive(message = "Maaş negatif bir değer olamaz")
	@NotNull(message = "Bu alan boş bırakılamaz")
	private BigDecimal salary;
}
