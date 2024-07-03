package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;


@Entity
@Table(name="student")
@Data
//@Setter
//@Getter
public class Student {
	@Id
	private Integer id;
	private String sname;
	private Integer sage;
	private String scity;
	public Student() {
		System.out.println("Control is in constructor..");
	}
	
	

}
