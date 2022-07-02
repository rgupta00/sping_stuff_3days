package com.empapp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//-------owner-(it own the relationship)--------------------
@Entity
@Table(name = "emp_table")
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	
	@JoinColumn(name = "pid_fk", nullable = false)
	@OneToOne(cascade = {CascadeType.PERSIST})
	private Parking parking;
	
	
	
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Employee(String empName) {
		this.empName = empName;
	}
	public Employee() {}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

	

}