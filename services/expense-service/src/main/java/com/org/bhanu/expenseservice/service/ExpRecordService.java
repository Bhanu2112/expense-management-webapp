package com.org.bhanu.expenseservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.repository.ExpRecordRepository;

@Service

public class ExpRecordService {
	
	@Autowired
	private ExpRecordRepository recordRepository;
	
	
	public ExpRecord createRecord(ExpRecord record) {
		return recordRepository.save(record);
	}
	
	public List<ExpRecord> findAllRecordsByUserId(Long userId){
		return recordRepository.findAllByUserId(userId);
	}
	
	

}
