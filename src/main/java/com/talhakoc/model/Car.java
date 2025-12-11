package com.talhakoc.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer year;
	      
	private Long mileage;
	
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "car_status")
	private CarStatus status;
	
	@ManyToOne
	private CarMake carMake;
	
	@ManyToOne
	private CarModel carModel;
	    
	@ManyToOne
	private CarEngine carEngine;
	
	@ManyToOne
	private CarFuel carFuel;
}
