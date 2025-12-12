package com.talhakoc.service;

import java.util.List;

import com.talhakoc.dto.car_sale.request.CarSaleCreateDto;
import com.talhakoc.dto.car_sale.response.CarSaleDto;

public interface ICarSaleService {

	public List<CarSaleDto> listAll();
	
	public CarSaleDto saveCarSale(CarSaleCreateDto carSaleCreateDto);
}
