package com.demo.service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.Customer;
import com.demo.dao.CustomerDao;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public List<Customer> getCustomers() {
		long start = System.currentTimeMillis();

		List<Customer> customers=customerDao.getCustomers();
		
		long end = System.currentTimeMillis();

		System.out.println("time taken: "+ (end-start));
		return customers;
	}

	public Flux<Customer> getCustomersStreams() {
		long start = System.currentTimeMillis();

		Flux<Customer> customersStreams = customerDao.getCustomersStreams();
		
		long end = System.currentTimeMillis();

		System.out.println("time taken flex: "+ (end-start));
		return customersStreams;
	}

}












