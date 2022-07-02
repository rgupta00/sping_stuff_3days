package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/hellourl")
	public ModelAndView hello() {
		ModelAndView mv=new ModelAndView();	
		//model: result of BP and view what is the next jsp page
		mv.setViewName("mypage");//we hv give the logical name of the jsp
		//who will resolve this name : viewResolver
		mv.addObject("message", "we all are champions");// i process  the data
		//the help of server 
		return mv;	//request dispaching* "servlet specification"
	}
}
