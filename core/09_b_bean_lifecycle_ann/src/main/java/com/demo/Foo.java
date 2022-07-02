package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo implements InitializingBean, DisposableBean, BeanNameAware{
	private String fooVal;

	
	public Foo() {
		System.out.println("public Foo()");
	}

	public String getFooVal() {
		return fooVal;
	}

	public void setFooVal(String fooVal) {
		System.out.println("public void setFooVal(String fooVal)");
		this.fooVal = fooVal;
	}
	
	//life cycle method 
	public void afterCreationFoo() {
		//cleanup
		System.out.println("afterCreationFoo().xml..");
	}
	
	public void beforeDestroyFoo() {
		//cleanup
		System.out.println("beforeDestroyFoo()..xml.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet.....InitializingBean");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy....DisposableBean.");
	}
	
	@PostConstruct
	public void postConstructUsingAnnoation() {
		System.out.println("postConstructUsingAnnoation....@PostConstruct");
	}
	

	@PreDestroy
	public void preDestroyedUsingAnnoation() {
		System.out.println("preDestroyedUsingAnnoation...@PreDestroy.");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware is called: "+ name);
	}
	
}
