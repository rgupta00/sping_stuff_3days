package com.customerapp.dao;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

public class Customer {
	private Integer id;
	private String email;
	private String name;
	private LocalDate dateOfBirth;
	private boolean active;
	public Customer(Integer id, String email, String name, LocalDate dateOfBirth, boolean active) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.active = active;
	}
	
	
	

}
