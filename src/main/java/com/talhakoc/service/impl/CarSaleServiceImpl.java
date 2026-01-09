package com.talhakoc.service.impl;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
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
import com.talhakoc.security.CustomUserDetails;
import com.talhakoc.service.ICarSaleService;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CarSaleServiceImpl  implements ICarSaleService{

	private final CarSaleMapper carSaleMapper;
	private final CarSaleRepository carSaleRepository;
	private final EmployeeRepository employeeRepository;
	private final CarRepository carRepository;
	
	@Override
	public List<CarSaleDto> listAll() {

        return carSaleRepository.findAll()
                .stream()
                .map(carSaleMapper::toDto)
                .toList();
	}

	@Override
    @Transactional
	public CarSaleDto saveCarSale(CarSaleCreateDto carSaleCreateDto) {
		
		Car car = carRepository.findById(carSaleCreateDto.getCarId())
				.orElseThrow(() -> new RuntimeException("Araç bulunamadı"));
		
		if(car.getCarStatus() == CarStatus.SOLD) {
			throw new RuntimeException("Bu araç zaten satılmış");
		}
		
		// Güvenlik: Authenticated user'dan employee'yi al
		CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		Employee employee = employeeRepository.findByUser(userDetails.getUser())
				.orElseThrow(() -> new RuntimeException("Çalışan bulunamadı. Bu işlem için çalışan olmanız gerekiyor."));

        CarSale carSale = new CarSale();

		carSale.setCar(car);
		carSale.setEmployee(employee);
		carSale.setSaleDate(carSaleCreateDto.getSaleDate());
		carSale.setSalePrice(carSaleCreateDto.getSalePrice());
		
		carSaleRepository.save(carSale);
		
		car.setCarStatus(CarStatus.SOLD);
		carRepository.save(car);
		
		return carSaleMapper.toDto(carSale);
	}

	
}
