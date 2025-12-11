package com.talhakoc.mapper;

import org.mapstruct.Mapper;

import com.talhakoc.dto.car.response.CarEngineDto;
import com.talhakoc.model.CarEngine;

@Mapper(componentModel = "spring")
public interface CarEngineMapper {

	CarEngine toEntity(CarEngineDto carEngineDto);
	
}
