package com.talhakoc.service;

import java.util.List;

import com.talhakoc.dto.car.request.CarCreateDto;
import com.talhakoc.dto.car.request.CarUpdateDto;
import com.talhakoc.dto.car.response.CarDto;

public interface ICarService {

	public List<CarDto> listAll();
	
	public CarDto saveCar(CarCreateDto carCreateDto);
	
	public CarDto updateCar(CarUpdateDto carUpdateDto);
	
	public void deleteCar(Long id);
}
