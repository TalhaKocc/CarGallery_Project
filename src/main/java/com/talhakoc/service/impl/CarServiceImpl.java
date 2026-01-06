package com.talhakoc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talhakoc.dto.car.request.CarCreateDto;
import com.talhakoc.dto.car.request.CarUpdateDto;
import com.talhakoc.dto.car.response.CarDto;
import com.talhakoc.mapper.CarMapper;
import com.talhakoc.model.Car;
import com.talhakoc.repository.CarEngineRepository;
import com.talhakoc.repository.CarFuelRepository;
import com.talhakoc.repository.CarMakeRepository;
import com.talhakoc.repository.CarModelRepository;
import com.talhakoc.repository.CarRepository;
import com.talhakoc.service.ICarService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {

	private final CarRepository carRepository;
	private final CarMapper carMapper;
	private final CarMakeRepository carMakeRepository;
	private final CarModelRepository carModelRepository;
	private final CarEngineRepository carEngineRepository;
	private final CarFuelRepository carFuelRepository;
	
	
	@Override
	public List<CarDto> listAll() {
		
		List<Car> cars = carRepository.findAll();
		return carMapper.toDtoList(cars);
	}

	@Override
	public CarDto saveCar(CarCreateDto carCreateDto) {
		
		Car car = carMapper.toEntity(carCreateDto);
		
		car.setCarMake(
				carMakeRepository.findById(carCreateDto.getCarMakeId())
				.orElseThrow(() -> new RuntimeException("Araba markası bulunamadı")));
		
		car.setCarModel(
				carModelRepository.findById(carCreateDto.getCarModelId())
				.orElseThrow(() -> new RuntimeException("Araba modeli bulunamadı")));
		
		car.setCarEngine(
				carEngineRepository.findById(carCreateDto.getCarEngineId())
				.orElseThrow(() -> new RuntimeException("Araba motoru bulunamadı")));
		
		car.setCarFuel(
				carFuelRepository.findById(carCreateDto.getCarFuelId())
				.orElseThrow(() -> new RuntimeException("Araba yakıt tipi bulunamadı")));
		
		car.setCarStatus(carCreateDto.getStatus());
		
		carRepository.save(car);
		
		return carMapper.toDto(car);
	}

	@Override
	public CarDto updateCar(CarUpdateDto carUpdateDto) {

		Car car = carRepository.findById(carUpdateDto.getId())
				.orElseThrow(() -> new RuntimeException("Araba bulunamadı"));
		
		carMapper.updateCarFromDto(carUpdateDto, car);
		
		car.setCarMake(
				carMakeRepository.findById(carUpdateDto.getCarMakeId())
				.orElseThrow(() -> new RuntimeException("Araba markası bulunamadı")));
		
		car.setCarModel(
				carModelRepository.findById(carUpdateDto.getCarModelId())
				.orElseThrow(() -> new RuntimeException("Araba modeli bulunamadı")));
		
		car.setCarEngine(
				carEngineRepository.findById(carUpdateDto.getCarEngineId())
				.orElseThrow(() -> new RuntimeException("Araba motoru bulunamadı")));
		
		car.setCarFuel(
				carFuelRepository.findById(carUpdateDto.getCarFuelId())
				.orElseThrow(() -> new RuntimeException("Araba yakıt tipi bulunamadı")));
		
		carRepository.save(car);
		
		return carMapper.toDto(car);
	}

	@Override
	public void deleteCar(Long id) {
		
		Car car = carRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Araç bulunamadı"));
		carRepository.delete(car);
	}

	
}
