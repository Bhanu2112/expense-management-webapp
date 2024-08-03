package com.org.bhanu.transactionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to transaction-service";
	}

}
