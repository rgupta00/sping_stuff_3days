package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.demo.Bike;
import com.demo.Car;
import com.demo.Passanger;
import com.demo.Vehical;

@Configuration
@ComponentScan(basePackages = "com.demo")
public class AppConfig {

	
	@Bean(name = "p")
	public Passanger getPassanger(Vehical vehical) {
		Passanger passanger=new Passanger();
		passanger.setName("Lee");
		passanger.setVehical(vehical);
		return passanger;
	}
	
	//getVehical1
	@Profile(value = "dev")
	@Bean
	public Vehical getVehical1() {
		Vehical vehical=new Bike();
		return vehical;
	}
	
	//getVehical2
	
	@Profile(value = "qa")
	@Bean
	public Vehical getVehical2() {
		Vehical vehical=new Car();
		return vehical;
	}
	
	
}
