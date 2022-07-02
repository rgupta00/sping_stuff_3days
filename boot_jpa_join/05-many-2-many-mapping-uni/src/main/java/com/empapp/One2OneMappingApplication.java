package com.empapp;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empapp.entities.Customer;
import com.empapp.entities.Service;
import com.empapp.repo.CustomerRepository;
import com.empapp.repo.ServiceRepository;

@SpringBootApplication
public class One2OneMappingApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ServiceRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(One2OneMappingApplication.class, args);
	}
	//just to initilized the data or some common code just after spring boot started

	@Override
	public void run(String... args) throws Exception {

		Customer customer=new Customer();
		customer.setName("Raja");
		customer.setEmailId("raja@gmail.com");
		customer.setDateOfBirth(LocalDate.of(2000, Month.JANUARY, 12));
		
		customer.getBankServices().add(new Service("laptop service", 3000));
		customer.getBankServices().add(new Service("washing machine service", 2000));
		
		
		customerRepository.save(customer);
		System.out.println("---------------");
	}

}
