package com.empapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "dept_table")
public class Department {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	
	private String deptName;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="dept_id_fk")
	private List<Employee> employees = new ArrayList<Employee>();

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department() {}

	public Department(String deptName) {
		this.deptName = deptName;
	}
	
	
	
}