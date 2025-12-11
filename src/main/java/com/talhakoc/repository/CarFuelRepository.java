package com.talhakoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talhakoc.model.CarFuel;

@Repository
public interface CarFuelRepository extends JpaRepository<CarFuel, Long>{

}
