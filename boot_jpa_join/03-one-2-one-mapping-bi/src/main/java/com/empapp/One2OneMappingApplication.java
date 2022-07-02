package com.empapp;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empapp.entities.Employee;
import com.empapp.entities.Parking;
import com.empapp.repo.EmployeeRepo;
import com.empapp.repo.ParkingRepo;

@SpringBootApplication
public class One2OneMappingApplication implements CommandLineRunner {

	@Autowired
	private ParkingRepo parkingRepo;
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(One2OneMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//initData();
		
		someExamples();
		
	}

	private void someExamples() {
		
		
		
		//List<Parking> parkingList=parkingRepo.findAll();
		
		//parkingList.forEach(p-> System.out.println(p));
		
		//add a emp with parknig
		
		//insertRecord();
		
		//fetching
//		Employee employee=employeeRepo.findById(7).orElseThrow(()-> new RuntimeException("emp is not found"));
//		employeeRepo.delete(employee);
//		System.out.println("--------------------");
//		System.out.println("---------------------");
//		System.out.println(employee);
//		System.out.println(employee.getParking());
		
//		Parking parking=parkingRepo.findById(7).orElseThrow(()-> new RuntimeException("parking is not found"));
//		System.out.println("---------------------");
//		System.out.println(parking);
//		System.out.println(parking.getEmployee());
		
		/*
		 * @JoinColumn(name = "pid_fk", nullable = false)
			@OneToOne(cascade = {CascadeType.MERGE})
			private Parking parking;
		 */
		
		//if u save emp parking is saved automatically
		
		Employee employee1 = new Employee("geeta");
		Parking parking1 = new Parking("XA1");
		employee1.setParking(parking1);
		parking1.setEmployee(employee1);
		
		//employeeRepo.save(employee1);
		parkingRepo.save(parking1);
		
		
	}

	private void insertRecord() {
		Employee employee1 = new Employee("raja");
		Parking parking1 = new Parking("N12");
		employee1.setParking(parking1);
		parking1.setEmployee(employee1);
		
		employeeRepo.save(employee1);
		parkingRepo.save(parking1);
	}

	private void initData() {
		Employee employee1 = new Employee("sumit");
		Employee employee2 = new Employee("ekta");
		Employee employee3 = new Employee("gun");
		Employee employee4 = new Employee("keshav");
		Employee employee5 = new Employee("vikas");

		Parking parking1 = new Parking("A12");
		Parking parking2 = new Parking("M2");
		Parking parking3 = new Parking("B2");
		Parking parking4 = new Parking("T11");
		Parking parking5 = new Parking("U12");

		parking1.setEmployee(employee1);
		parking2.setEmployee(employee2);
		parking3.setEmployee(employee3);
		parking4.setEmployee(employee4);
		parking5.setEmployee(employee5);
//		
		employee1.setParking(parking1);
		employee2.setParking(parking2);
		employee3.setParking(parking3);
		employee4.setParking(parking4);
		employee5.setParking(parking5);
		
		
		employeeRepo.save(employee1);
		employeeRepo.save(employee2);
		employeeRepo.save(employee3);
		employeeRepo.save(employee4);
		employeeRepo.save(employee5);
		
		parkingRepo.save(parking1);
		parkingRepo.save(parking2);
		parkingRepo.save(parking3);
		parkingRepo.save(parking4);
		parkingRepo.save(parking5);
	
		System.out.println("done");
	}

}
