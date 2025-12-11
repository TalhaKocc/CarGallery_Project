package com.talhakoc.mapper;

import org.mapstruct.Mapper;

import com.talhakoc.dto.car.response.CarFuelDto;
import com.talhakoc.model.CarFuel;

@Mapper(componentModel = "spring")
public interface CarFuelMapper {

	CarFuel carFuel(CarFuelDto carFuelDto);
	
}
