package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.Customer;
import com.demo.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "customer-traditional")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	@GetMapping(path = "customer-streams", 
			produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Customer> getCustomersStreams() {
		return customerService.getCustomersStreams();
	}

}
