package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("demo.xml");
		//Passanger passanger=(Passanger) applicationContext.getBean("p");
		System.out.println("--------------");
		//passanger.travel();
		//System.out.println(passanger.hashCode());
		
		//Passanger passanger2=(Passanger) applicationContext.getBean("p");
		
		//System.out.println(passanger2.hashCode());
		
		
//			Vehical vehical=new Car();
//			
//			// pull :( coupling, you have to manage object ur self
//			//ie u have to mange life cycle of 100 of object
//			//if u do it when you will time to do ur business req
//			
//			//Passanger ----> Vehical 
//			Passanger passanger=new Passanger();
//			passanger.setName("lee");
//			passanger.setVehical(vehical);
//			
//			
//			passanger.travel();
	}

}
