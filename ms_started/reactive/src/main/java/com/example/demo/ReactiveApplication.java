package com.example.demo;

import javax.management.RuntimeErrorException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class ReactiveApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		Mono<?> mono=Mono.just("champion")
//				.then(Mono.error(new RuntimeException("exception occured")))
//				.log();
//		mono.subscribe(System.out::print);
		
		
//		Mono<String> mono=Mono.just("champion").log();
//		mono.subscribe(System.out::print);
	}

}
