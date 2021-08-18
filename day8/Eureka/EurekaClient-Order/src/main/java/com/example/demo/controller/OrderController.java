package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@GetMapping("/getorders")
	public String displayOrder() {
		return "Here is the order details";
	}

}
