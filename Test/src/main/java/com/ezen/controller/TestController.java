package com.ezen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	
	@GetMapping("/hello")
	public void hello() {
		System.out.println("hello.............................."); 
	}
}
