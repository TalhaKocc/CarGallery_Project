package com.talhakoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "car_model")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(nullable = false, unique = true)
	private String name;

    @OneToMany(mappedBy = "carModel", fetch = FetchType.LAZY)
    private List<Car> cars;
}
