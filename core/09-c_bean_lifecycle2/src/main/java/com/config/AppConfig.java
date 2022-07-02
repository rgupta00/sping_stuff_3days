package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.Foo;

@Configuration
@ComponentScan(basePackages = {"com.demo"})
public class AppConfig {

	@Bean(name = "foo", initMethod = "myPostCtr", destroyMethod = "myPreDestroy")
	public Foo foo() {
		Foo foo=new Foo();
		foo.setFooVal("foo value");
		return foo;
	}
}
