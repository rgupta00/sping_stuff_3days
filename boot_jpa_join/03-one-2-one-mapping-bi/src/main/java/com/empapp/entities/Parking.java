package com.empapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//-------revser owner : will always contain a tage : mappedBy-----------
@Entity
@Table(name = "parking_table")
public class Parking {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int partingId;
	private String parkingLocation;

	
	@OneToOne(mappedBy = "parking", cascade = CascadeType.ALL)
	private Employee employee;

	public int getPartingId() {
		return partingId;
	}

	public void setPartingId(int partingId) {
		this.partingId = partingId;
	}

	public String getParkingLocation() {
		return parkingLocation;
	}

	public void setParkingLocation(String parkingLocation) {
		this.parkingLocation = parkingLocation;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Parking() {}

	public Parking(String parkingLocation) {
		super();
		this.parkingLocation = parkingLocation;
	}

	@Override
	public String toString() {
		return "Parking [partingId=" + partingId + ", parkingLocation=" + parkingLocation + ", employee=" + employee
				+ "]";
	}
	
	
}