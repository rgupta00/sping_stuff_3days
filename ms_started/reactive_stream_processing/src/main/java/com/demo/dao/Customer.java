package com.demo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor

public class Customer {
	private int id;
	private String name;
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
}
