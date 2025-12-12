package com.talhakoc.dto.car.request;

import java.math.BigDecimal;

import com.talhakoc.model.CarStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarCreateDto {

	@NotNull
	private Long carMakeId;
	
	@NotNull
	private Long carModelId;
	
	@NotNull
	private Long carEngineId;
	
	@NotNull
	private Long carFuelId;
	
	@NotNull
	private CarStatus status;
	
	@NotNull
	@Min(2000)
	private Integer year;
	
	@NotNull
	@PositiveOrZero(message = "Lütfen 0 veya pozitif sayı giriniz")
	private Long mileage;
	
	@NotNull
	@Positive(message = "Lütfen pozitif sayı giriniz")
	private BigDecimal price;
	
}
