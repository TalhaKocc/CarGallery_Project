package com.talhakoc.dto.car_sale.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarSaleCreateDto {
	
	@NotNull
	private Long carId;
	
	@NotNull
	@Positive(message = "Lütfen pozitif bir sayı giriniz")
	private BigDecimal salePrice;
	
	@NotNull
	@PastOrPresent(message = "Satış tarihi gelecekte olamaz")
	private LocalDate saleDate;
	
}
