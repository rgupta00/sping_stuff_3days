package com.customer;
import java.util.*;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		//crudOperation();
		
		generateMethods();
		
	}
	private void generateMethods() throws InfyException {
//		public Optional<Customer> findByEmailId(String emailId);
		
//		Customer customer=customerRepository.findByEmailId("raj@gmal.com")
//				.orElseThrow(()-> new InfyException("emp is not found"));
//		System.out.println(customer);
		
		
//		public Optional<Customer> findByEmailIdAndName(String emailId, String name);

//		Customer customer=customerRepository.findByEmailIdAndName("raj@gmal.com","raj1")
//				.orElseThrow(()-> new InfyException("customer is not found"));
//		System.out.println(customer);
		
		
	//	public Optional<Customer> findByEmailIdOrName(String emailId, String name);
		
//		Customer customer=customerRepository.findByEmailIdOrName("raj@gmal.com","raj1")
//				.orElseThrow(()-> new InfyException("customer is not found"));
//		System.out.println(customer);
		
//		
//		public List<Customer> findByEmailIdNull();
//		Customer customerNew = new Customer( null, "foo", LocalDate.of(1970, Month.JANUARY, 22));
//		customerRepository.save(customerNew);
//		Customer customerNew2 = new Customer( null, "bar", LocalDate.of(1970, Month.JANUARY, 22));
//		customerRepository.save(customerNew2);
//		
//		List<Customer> findByEmailIds=customerRepository.findByEmailIdNull();
//		System.out.println("----------");
//		findByEmailIds.forEach(c-> System.out.println(c));
//		
//		public List<Customer> findByNameLike(String pattern);// ra 
//		
//		public List<Customer> findByDateOfBirthAfter(LocalDate localDate);

		List<Customer> customersAfter=customerRepository.findByDateOfBirthAfter
				(LocalDate.of(1980, Month.APRIL, 23));
		
		customersAfter.forEach(c-> System.out.println(c));
		
//		public List<Customer> findByDateOfBirthBefore(LocalDate localDate);
//		
//		//i want customer records but it should arrrange as per there dob in desc
//		public List<Customer> findByNameOrderByDateOfBirthDesc(String name);
	}

	private void crudOperation() throws InfyException {
		//C
		Customer customerNew = new Customer( "suman@gmal.com", "suman", LocalDate.of(1970, Month.JANUARY, 22));
		customerRepository.save(customerNew);
		
		//R
		List<Customer> customers=customerRepository.findAll();
		customers.forEach(customer-> System.out.println(customer));
		
		//get One customer
		
		Customer customer=customerRepository.findById(3)
				.orElseThrow(()-> new InfyException("customer is not found"));
		//U
		
		customer.setEmailId("pankaj123@gmal.com");
		customerRepository.save(customer);
		
		//D
	
		customerRepository.delete(customer);
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
