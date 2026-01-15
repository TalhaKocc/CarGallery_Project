package com.talhakoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "car_fuel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarFuel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(nullable = false, unique = true)
	private String name;

    @OneToMany(mappedBy = "carFuel", fetch = FetchType.LAZY)
    private List<Car> cars;
}
