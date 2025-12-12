package com.talhakoc.dto.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {

	@Email(message = "Lütfen eamil formatında giriniz")
	@NotBlank(message = "Bu alan boş bırakılamaz")
	private String email;
	
	@NotBlank(message = "Bu alan boş bırakılamaz")
	private String password;

}
