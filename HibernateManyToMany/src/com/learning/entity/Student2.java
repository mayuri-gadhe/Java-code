package com.learning.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Student2 {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer sid;
	@NonNull
	private String sname;
	@NonNull
	private String city;
	@NonNull
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Course> courses;

}
