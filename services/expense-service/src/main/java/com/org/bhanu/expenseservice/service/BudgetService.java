package com.org.bhanu.expenseservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.Budget;
import com.org.bhanu.expenseservice.entity.BudgetManager;
import com.org.bhanu.expenseservice.repository.BudgetManagerRepository;
import com.org.bhanu.expenseservice.repository.BudgetRepository;

@Service
public class BudgetService {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Autowired
	private BudgetManagerRepository budgetManagerRepository;
	
	
	public List<Budget> getBudgets(){
		return budgetRepository.findAll();
	}
	
	public List<BudgetManager> getBudgetManagers(){
		return budgetManagerRepository.findAll();
	}

}
