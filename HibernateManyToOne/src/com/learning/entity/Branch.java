package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Branch {
	@Id
	private String bid;
	private String branchName;
	private String branchLocation;

}
