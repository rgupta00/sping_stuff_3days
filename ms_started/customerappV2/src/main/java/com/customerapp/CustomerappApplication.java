package com.customerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class CustomerappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerappApplication.class, args);
	}

}
