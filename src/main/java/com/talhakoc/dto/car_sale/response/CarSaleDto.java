package com.talhakoc.dto.car_sale.response;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.talhakoc.dto.car.response.CarDto;
import com.talhakoc.dto.employee.response.EmployeeDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarSaleDto {

	private Long id;
	
	private LocalDate saleDate;
	
	private BigDecimal salePrice;
	
	private CarDto car;
	
	private EmployeeDto employee;
	
}
