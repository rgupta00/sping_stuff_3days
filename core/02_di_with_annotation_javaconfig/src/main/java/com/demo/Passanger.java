package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//passanger is rep for managing it own dep: passanger is "pulling" the dep
//SOLID: OCP

@Component(value = "p")	// <bean id="p" class="com.demo.Passanger" 
public class Passanger {

	@Value(value = "Lee")	//<property name="name" value="Lee"/>
	private String name;
	
	@Autowired
	private Vehical vehical;


	public Passanger() {
		System.out.println("ctr of passanger is called");
	}

	public Passanger(String name, Vehical vehical) {
		super();
		this.name = name;
		this.vehical = vehical;
	}

	public void setVehical(Vehical vehical) {
		this.vehical = vehical;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void travel() {
		System.out.println("name of passanger: " + name);
		vehical.move();
	}

}
