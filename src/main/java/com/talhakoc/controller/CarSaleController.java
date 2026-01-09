package com.talhakoc.controller;

import com.talhakoc.dto.car_sale.request.CarSaleCreateDto;
import com.talhakoc.dto.car_sale.response.CarSaleDto;
import com.talhakoc.service.ICarSaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carSale")
@RequiredArgsConstructor
public class CarSaleController {

    private final ICarSaleService carSaleService;

    @GetMapping("/list")
    public ResponseEntity<List<CarSaleDto>> getAllCarSale(){
        return ResponseEntity.ok(carSaleService.listAll());
    }

    @PostMapping("/save")
    public ResponseEntity<CarSaleDto> saveCarSale(@Valid @RequestBody CarSaleCreateDto carSaleCreateDto){
        return ResponseEntity.ok(carSaleService.saveCarSale(carSaleCreateDto));
    }
}
