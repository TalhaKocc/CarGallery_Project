package com.talhakoc.dto.car.request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarUpdateDto {

	private Long id;
	
	private Long carMakeId;
	
	private Long carModelId;
	
	private Long carEngineId;
	
	private Long carFuelId;
	
	private Integer year;
	
	private Long mileage;
	
	private BigDecimal price;
}
