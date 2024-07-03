package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String city;
	private Double salary;
	
	public Employee()
	{
		System.out.println("Employee zero param constructor for hibernate internal");
	}


	public Employee(String name, String city, Double salary) {
		super();
		this.name = name;
		this.city = city;
		this.salary = salary;
	}
}
