package com.talhakoc.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.talhakoc.dto.car_sale.request.CarSaleCreateDto;
import com.talhakoc.dto.car_sale.response.CarSaleDto;
import com.talhakoc.model.CarSale;

@Mapper(componentModel = "spring",uses = {
		EmployeeMapper.class,
		CarMapper.class
})
public interface CarSaleMapper {

	@Mapping(target = "id",ignore = true)
	@Mapping(target = "car", ignore = true)
	@Mapping(target = "employee", ignore = true)
	CarSale toEntity(CarSaleCreateDto carSaleCreateDto);
	
	CarSaleDto toDto(CarSale carSale);
	
	List<CarSaleDto> toDtoList(List<CarSale> carSales);
}
