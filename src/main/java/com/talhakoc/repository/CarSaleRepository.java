package com.talhakoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talhakoc.model.CarSale;

@Repository
public interface CarSaleRepository extends JpaRepository<CarSale,Long> {

}
