package com.org.bhanu.expenseservice.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.ExpCategory;
import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.repository.ExpCategoryRepository;
import com.org.bhanu.expenseservice.repository.ExpRecordRepository;

@Service
public class ExpCategoryService {
	
	@Autowired
	private ExpCategoryRepository categoryRepository;
	
	@Autowired
	private ExpRecordRepository recordRepository;
	
	
	public ExpCategory saveCategory(ExpCategory category) {
		return categoryRepository.save(category);
	}
	
	
	public List<ExpCategory> getAllCategoriesOfUser(Long userId){
		return categoryRepository.findAllByUserId(userId);
	}
	
	
	public Map<String, List<ExpRecord>> getAllCategoriesOfUserWithRecords(Long userId){
		
		
		List<ExpRecord> records = recordRepository.findAllByUserId(userId);
		
		 Map<String, List<ExpRecord>> recordsList = records
				 .stream()
				 .collect(Collectors
						 .groupingBy(r -> r.getCategory().getCategoryName() ,
						 Collectors.toList()));
		
		return recordsList;
	}
	
	
	

}
