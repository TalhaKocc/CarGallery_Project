package com.talhakoc.controller;

import com.talhakoc.dto.car_sale.response.CarSaleDto;
import com.talhakoc.service.ICarSaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carSale")
@RequiredArgsConstructor
public class CarSaleController {

    private final ICarSaleService carSaleService;

    public ResponseEntity<List<CarSaleDto>> getAllCarSale(){

    }





}
