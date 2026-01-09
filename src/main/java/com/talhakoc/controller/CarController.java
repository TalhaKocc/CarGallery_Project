package com.talhakoc.controller;

import com.talhakoc.dto.car.request.CarCreateDto;
import com.talhakoc.dto.car.request.CarUpdateDto;
import com.talhakoc.dto.car.response.CarDto;
import com.talhakoc.service.ICarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    @GetMapping("/list")
    public ResponseEntity<List<CarDto>> findAll(){
        return ResponseEntity.ok(carService.listAll());
    }

    @PostMapping("/save")
    public ResponseEntity<CarDto> saveCar(@Valid @RequestBody CarCreateDto carCreateDto){
        return ResponseEntity.ok(carService.saveCar(carCreateDto));
    }

    @PutMapping("/update")
    public ResponseEntity<CarDto>  updateCar(@Valid @RequestBody CarUpdateDto carUpdateDto){
        return ResponseEntity.ok(carService.updateCar(carUpdateDto));
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        return ResponseEntity.ok(carService.deleteCar(id));
    }

}
