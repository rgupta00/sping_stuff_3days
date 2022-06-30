package com.demo;

//passanger is rep for managing it own dep: passanger is "pulling" the dep
//SOLID: OCP
public class Passanger {

	private String name;
	private Vehical vehical;


	public Passanger() {
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
