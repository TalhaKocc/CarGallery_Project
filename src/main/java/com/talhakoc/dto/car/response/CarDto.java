package com.talhakoc.dto.car.response;

import java.math.BigDecimal;

import com.talhakoc.model.CarStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

	private Long id;
	
	private CarMakeDto carMake;
	
	private CarModelDto carModel;
	
	private CarEngineDto carEngine;
	
	private CarFuelDto carFuel;
	
	private CarStatus status;
	
	private Integer year;
	
	private Long mileage;
	
	private BigDecimal price;
	
}
