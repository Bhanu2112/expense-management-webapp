package com.org.bhanu.expenseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhanu.expenseservice.entity.Budget;
import com.org.bhanu.expenseservice.entity.BudgetManager;
import com.org.bhanu.expenseservice.service.BudgetService;

@RestController
@RequestMapping("budget")
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
}
