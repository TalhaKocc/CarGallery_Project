package com.talhakoc.mapper;

import org.mapstruct.Mapper;

import com.talhakoc.dto.car.response.CarMakeDto;
import com.talhakoc.model.CarMake;

@Mapper(componentModel = "spring")
public interface CarMakeMapper {

	CarMake toEntitiy(CarMakeDto carMakeDto);
	
}	
