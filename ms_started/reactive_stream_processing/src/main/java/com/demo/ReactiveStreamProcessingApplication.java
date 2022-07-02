package com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ReactiveStreamProcessingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ReactiveStreamProcessingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//how to use mono
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//demoMono();
		
		//Flex
		//flexDemo();
		
		//how to use flex
	}

	private void flexDemo() {
		Flux<String> flexDemo = Flux.just("spring","design pattern","ds","rdbms","os")
				.concatWithValues("hibernate")
				.concatWith(Flux.error(new RuntimeException("excetion happens")))
				.concatWithValues("aws")
				.log();
		
		
		flexDemo.subscribe(System.out::print,e-> System.out.println(e.getMessage()) );
	}

	private void demoMono() {
		Mono<?> monoString = Mono.just("the java champs")
			.then(Mono.error(new RuntimeException("excetion happens")))
		.log();
		
		monoString.subscribe(System.out::print, e-> System.out.println(e.getMessage()));
	}

}
