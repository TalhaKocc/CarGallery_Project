package com.talhakoc.mapper;

import org.mapstruct.Mapper;

import com.talhakoc.dto.car.response.CarModelDto;
import com.talhakoc.model.CarModel;

@Mapper(componentModel = "spring")
public interface CarModelMapper {
	
	CarModel toEntity(CarModelDto carModelDto);

}
