package com.talhakoc.model;

import java.math.BigDecimal;
import java.util.List;

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

    @Column(nullable = false)
	private Integer year;

    @Column(nullable = false)
	private Long mileage;

    @Column(nullable = false)
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "car_status")
	private CarStatus carStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_make_id")
	private CarMake carMake;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_model_id")
	private CarModel carModel;
	    
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_engine_id")
	private CarEngine carEngine;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_fuel_id")
	private CarFuel carFuel;

    @OneToMany(mappedBy = "car")
    private List<CarSale> carSales;
}
