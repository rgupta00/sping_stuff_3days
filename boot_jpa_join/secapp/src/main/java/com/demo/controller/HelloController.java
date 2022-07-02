package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path = "home")
	public String home() {
		return "home";
	}

	@GetMapping(path = "mgr")
	public String mgr() {
		return "mgr";
	}

	@GetMapping(path = "admin")
	public String admin() {
		return "admin";
	}

	@GetMapping(path = "emp")
	public String emp() {
		return "emp";
	}

}
