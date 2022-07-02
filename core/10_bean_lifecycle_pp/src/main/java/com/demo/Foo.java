package com.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Foo {
	private String fooVal;

	public Foo() {
		System.out.println("public Foo()");
	}

	public void setFooVal(String fooVal) {
		System.out.println("public void setFooVal(String fooVal)");
		this.fooVal = fooVal;
	}

	@PostConstruct
	public void postConstructUsingAnnoation() {
		System.out.println("postConstructUsingAnnoation....@PostConstruct");
	}

	public String getFooVal() {
		return fooVal;
	}

	@PreDestroy
	public void preDestroyedUsingAnnoation() {
		System.out.println("preDestroyedUsingAnnoation...@PreDestroy.");
	}

}
