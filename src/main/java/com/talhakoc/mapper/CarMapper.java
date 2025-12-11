package com.talhakoc.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.talhakoc.dto.car.request.CarCreateDto;
import com.talhakoc.dto.car.request.CarUpdateDto;
import com.talhakoc.dto.car.response.CarDto;
import com.talhakoc.model.Car;

@Mapper(componentModel = "spring",uses = {
		CarMakeMapper.class,
		CarModelMapper.class,
		CarEngineMapper.class,
		CarFuelMapper.class
})

public interface CarMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "carMake", ignore = true)
	@Mapping(target = "carModel", ignore = true)
	@Mapping(target = "carEngine", ignore = true)
	@Mapping(target = "carFuel", ignore = true)
	Car toEntity(CarCreateDto carCreateDto);
	
	CarDto toDto(Car car);

	@Mapping(target = "carMake", ignore = true)
	@Mapping(target = "carModel", ignore = true)
	@Mapping(target = "carEngine", ignore = true)
	@Mapping(target = "carFuel", ignore = true)
	@Mapping(target = "status", ignore = true)
	void updateCarFromDto(CarUpdateDto carUpdateDto, @MappingTarget Car car);

	List<CarDto> toDtoList(List<Car> cars);

}
