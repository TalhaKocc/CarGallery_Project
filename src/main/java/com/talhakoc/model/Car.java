package com.talhakoc.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
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
	private CarStatus carStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CarMake carMake;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CarModel carModel;
	    
	@ManyToOne(fetch = FetchType.LAZY)
	private CarEngine carEngine;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CarFuel carFuel;
}
