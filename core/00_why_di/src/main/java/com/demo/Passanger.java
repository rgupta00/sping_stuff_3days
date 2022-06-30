package com.demo;

public class Passanger {

	private String name;
	private Car  car=new Car();
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void travel() {
		System.out.println("name of passanger: "+ name);
		car.move();
	}
	
}
