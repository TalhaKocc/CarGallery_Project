package com.talhakoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "car_engine")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarEngine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "engine_size",nullable = false,unique = true)
	private String engineSize;

    @OneToMany(mappedBy = "carEngine", fetch = FetchType.LAZY)
    private List<Car> cars;
}
