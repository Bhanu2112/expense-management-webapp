package com.org.bhanu.expenseservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhanu.expenseservice.entity.ExpCategory;
import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.service.ExpCategoryService;

@RestController
@CrossOrigin
public class ExpCategoryController {
	
	
	@Autowired
	private ExpCategoryService categoryService;
	
	@PostMapping("/category/create")
	public ExpCategory createCategory(@RequestBody ExpCategory category) {
		return categoryService.saveCategory(category);
	}
	
	@GetMapping("/categories/{userId}")
	public List<ExpCategory> getAllCategories(@PathVariable Long userId){
		return categoryService.getAllCategoriesOfUser(userId);
		
	}
	
	@GetMapping("/categories/user/{userId}")
	public Map<String, List<ExpRecord>> getAllCategoriesWithRecords(@PathVariable Long userId){
		return categoryService.getAllCategoriesOfUserWithRecords(userId);
		
	}
	
	
	

}
