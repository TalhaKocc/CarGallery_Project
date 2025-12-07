package com.talhakoc.dto.car_sale.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarSaleCreateDto {
	
	private Long carId;
	
	private Long employeeId;
	
	private BigDecimal salePrice;
	
	private LocalDate saleDate;
	
}
