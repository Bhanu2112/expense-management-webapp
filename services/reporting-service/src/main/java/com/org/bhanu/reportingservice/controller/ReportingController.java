package com.org.bhanu.reportingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reporting")
public class ReportingController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to reporting-service";
	}

}
