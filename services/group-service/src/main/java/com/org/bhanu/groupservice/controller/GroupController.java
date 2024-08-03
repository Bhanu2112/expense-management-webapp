package com.org.bhanu.groupservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to group-service";
	}

}
