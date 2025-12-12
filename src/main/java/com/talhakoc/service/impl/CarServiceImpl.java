package com.talhakoc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talhakoc.dto.car.request.CarCreateDto;
import com.talhakoc.dto.car.request.CarUpdateDto;
import com.talhakoc.dto.car.response.CarDto;
import com.talhakoc.mapper.CarMapper;
import com.talhakoc.model.Car;
import com.talhakoc.repository.CarRepository;
import com.talhakoc.service.ICarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {

	private final CarRepository carRepository;
	private final CarMapper carMapper;
	
	
	@Override
	public List<CarDto> listAll() {
		List<Car> cars = carRepository.findAll();
		return carMapper.toDtoList(cars);
	}

	@Override
	public CarDto saveCar(CarCreateDto carCreateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarDto updateCar(CarUpdateDto carUpdateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCar(Long id) {
		// TODO Auto-generated method stub
		
	}

	
}
