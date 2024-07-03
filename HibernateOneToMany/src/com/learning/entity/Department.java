package com.learning.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Department {
	@Id
	private String deptId;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Employee> employee;

}
