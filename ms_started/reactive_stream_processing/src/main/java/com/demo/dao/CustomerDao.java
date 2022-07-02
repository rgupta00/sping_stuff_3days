package com.demo.dao;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public class CustomerDao {

	private static void customSleep(int a) {
		try {
			TimeUnit.SECONDS.sleep(10);
		}catch(InterruptedException e) {}
	}
	
	public List<Customer> getCustomers(){
		return  IntStream.rangeClosed(1, 100)
				.peek(CustomerDao::customSleep)
				.peek(i-> System.out.println(i))
				.mapToObj(i-> new Customer(i, "customer "+ i))
				.collect(Collectors.toList());
	
	}
	

	public Flux<Customer> getCustomersStreams(){
		return  Flux.range(1, 100)
				.delayElements(Duration.ofSeconds(10))
				.doOnNext(i-> System.out.println("processing frm stram flow : "+ i))
				.map(i-> new Customer(i, "customer "+ i) );
	}
	
}








