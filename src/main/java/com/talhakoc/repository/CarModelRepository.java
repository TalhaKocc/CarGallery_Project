package com.talhakoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talhakoc.model.CarModel;

@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {

}
