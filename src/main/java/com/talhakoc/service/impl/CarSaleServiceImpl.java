package com.talhakoc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.talhakoc.dto.car_sale.request.CarSaleCreateDto;
import com.talhakoc.dto.car_sale.response.CarSaleDto;
import com.talhakoc.mapper.CarSaleMapper;
import com.talhakoc.model.Car;
import com.talhakoc.model.CarSale;
import com.talhakoc.model.CarStatus;
import com.talhakoc.model.Employee;
import com.talhakoc.repository.CarRepository;
import com.talhakoc.repository.CarSaleRepository;
import com.talhakoc.repository.EmployeeRepository;
import com.talhakoc.service.ICarSaleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarSaleServiceImpl  implements ICarSaleService{

	private final CarSale carSale;
	private final CarSaleMapper carSaleMapper;
	private final CarSaleRepository carSaleRepository;
	private final EmployeeRepository employeeRepository;
	private final CarRepository carRepository;
	
	@Override
	public List<CarSaleDto> listAll() {
		
		List<CarSale> carSales = carSaleRepository.findAll();
		
		return carSaleMapper.toDtoList(carSales);
	}

	@Override
	public CarSaleDto saveCarSale(CarSaleCreateDto carSaleCreateDto) {
		
		Car car = carRepository.findById(carSaleCreateDto.getCarId())
				.orElseThrow(() -> new RuntimeException("Araç bulunamadı"));
		
		if(car.getStatus() == CarStatus.SOLD) {
			throw new RuntimeException("Bu araç zaten satılmış");
		}
		
		Employee employe = employeeRepository.findById(carSaleCreateDto.getEmployeeId())
				.orElseThrow(() -> new RuntimeException("Çalışan bulunamadı"));
		
		carSale.setCar(car);
		carSale.setEmployee(employe);
		
		carSaleRepository.save(carSale);
		
		car.setStatus(CarStatus.SOLD);
		carRepository.save(car);
		
		return carSaleMapper.toDto(carSale);
	}

	
}
