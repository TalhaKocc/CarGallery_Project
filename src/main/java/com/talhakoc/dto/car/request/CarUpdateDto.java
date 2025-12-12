package com.talhakoc.dto.car.request;

import java.math.BigDecimal;

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
public class CarUpdateDto {

	@NotNull
	private Long id;
	
	@NotNull
	private Long carMakeId;
	
	@NotNull
	private Long carModelId;
	
	@NotNull
	private Long carEngineId;
	
	@NotNull
	private Long carFuelId;
	
	@NotNull
	@Min(2000)
	
	private Integer year;
	
	@NotNull
	@PositiveOrZero(message = "Mil 0 veya pozitif olmalıdır")
	private Long mileage;
	
	@NotNull
	@Positive(message = "Fiyat değeri pozitif olmalıdır")
	private BigDecimal price;
}
