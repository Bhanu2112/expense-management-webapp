package com.org.bhanu.expenseservice.service;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<ExpRecord> getRecordsByMonthAndYear(int month, int year,Long memberId) {
		List<ExpRecord> monthlyRecords = recordRepository.findByMonthAndYear(month, year,memberId);
		
		
		monthlyRecords.stream().collect(Collectors.groupingBy(ExpRecord::getDate)).entrySet()
		.forEach(e -> System.out.println( e.getKey()));
        
        
        return recordRepository.findByMonthAndYear(month, year,memberId);
        
    }

}
