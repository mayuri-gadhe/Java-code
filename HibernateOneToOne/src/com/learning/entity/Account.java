package com.learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	private String accId;
	private String accName;
	private String accType;

}
