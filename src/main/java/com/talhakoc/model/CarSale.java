package com.talhakoc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "car_sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarSale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "sale_date")
	private LocalDate saleDate;
	
	@Column(name = "sale_price")
	private BigDecimal salePrice;
	
	@ManyToOne
	private Car car;
	
	@ManyToOne
	private User user;
	
}
