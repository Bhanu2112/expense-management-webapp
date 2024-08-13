package com.org.bhanu.expenseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhanu.expenseservice.entity.Budget;
import com.org.bhanu.expenseservice.entity.BudgetManager;
import com.org.bhanu.expenseservice.service.BudgetService;

@RestController
@RequestMapping("budget")
@CrossOrigin
public class BudgetController {

	@Autowired
	private BudgetService budgetService;
	
	@GetMapping("/allbudgets")
	public List<Budget> getAllBudgets(){
		return budgetService.getBudgets();
	}
	
	@GetMapping("/manager")
	public List<BudgetManager> getAllBugetManger(){
		return budgetService.getBudgetManagers();
	}
	
	@PostMapping("/save")
	public Budget save(@RequestBody Budget budget) {
		return budgetService.saveBudget(budget);
	}
	
	@GetMapping("/bm/user")
	public BudgetManager getBm(@RequestParam String monthYear, @RequestParam Long userId) {
		return budgetService.bmList(monthYear,userId);
	}
	

}
