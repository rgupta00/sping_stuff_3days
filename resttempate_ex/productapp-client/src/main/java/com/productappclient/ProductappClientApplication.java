package com.productappclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
// we will write the name of package where we will keep proxy

@EnableFeignClients("com.productappclient.service")
@SpringBootApplication
public class ProductappClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappClientApplication.class, args);
	}
	
	//configure RestTemplate: aka template dp
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
