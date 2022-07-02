package com.customer;
import java.util.*;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.customer.dto.CustomerData;
import com.customer.exceptions.InfyException;
import com.customer.repository.Customer;
import com.customer.repository.CustomerRepository;

@SpringBootApplication
public class DemoJpaBootApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoJpaBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//init();
		
		testAllQuaries();
	}
	

	
	private void testAllQuaries() {
//		@Query(nativeQuery = false, value = "select c from Customer c where c.emailId=:emailId")
//		public Customer getMeCustomerByEmailIDxzy(@Param("emailId") String emailId);
		
//		Customer customer=customerRepository.getCustomerByEmail("raj@gmal.com");
//		System.out.println(customer);
		
		
//		String name=customerRepository.getCustomerNameByEmail("raj@gmal.com");
//		System.out.println(name);
		
//		CustomerData customerData=customerRepository.getCustomerNameAndEmail("raj@gmal.com");
//		System.out.println(customerData);
		
		//customerRepository.updateEmail("pankajabc@gmal.com", 3);
		
		customerRepository.deleteCustomerEmail("pankajabc@gmal.com");
	}

	private void init() {
		Customer customer1 = new Customer( "raj@gmal.com", "raj", LocalDate.of(1990, Month.JANUARY, 12));

		Customer customer2 = new Customer( "ekta@gmal.com", "ekta", LocalDate.of(1990, Month.JANUARY, 2));

		Customer customer3 = new Customer( "pankaj@gmal.com", "pankaj", LocalDate.of(1980, Month.JANUARY, 12));

		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
		System.out.println("i will always run....");
	}

}
