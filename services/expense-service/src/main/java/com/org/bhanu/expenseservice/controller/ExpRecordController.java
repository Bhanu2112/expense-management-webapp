package com.org.bhanu.expenseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.repository.ExpRecordRepository;
import com.org.bhanu.expenseservice.service.ExpRecordService;

@RestController
public class ExpRecordController {
	
	@Autowired
	private ExpRecordService recordService;
	
	@PostMapping("/create/record")
	public ExpRecord createRecord(@RequestBody ExpRecord record) {
		return recordService.createRecord(record);
	}
	
	@GetMapping("/record/{userId}")
	public List<ExpRecord> getAllReordsOfUser(@PathVariable Long userId){
		return recordService.findAllRecordsByUserId(userId);
	}

}
