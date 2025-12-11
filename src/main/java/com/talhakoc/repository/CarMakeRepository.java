package com.talhakoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talhakoc.model.CarMake;

@Repository
public interface CarMakeRepository extends JpaRepository<CarMake, Long> {

}
