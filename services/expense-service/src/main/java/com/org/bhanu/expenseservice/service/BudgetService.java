package com.org.bhanu.expenseservice.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.Budget;
import com.org.bhanu.expenseservice.entity.BudgetManager;
import com.org.bhanu.expenseservice.entity.BudgetMangerIds;
import com.org.bhanu.expenseservice.repository.BudgetManagerRepository;
import com.org.bhanu.expenseservice.repository.BudgetRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
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
	

	public BudgetManager bmList(String dateMonth, Long userId) {
		
		BudgetMangerIds ids = new BudgetMangerIds();
		ids.setMonthYear(dateMonth);
		ids.setUserId(userId);
		return budgetManagerRepository.findById(ids).get();
	}
	
	
	public Budget saveBudget(Budget budget) {
	    budget.setCreatedAt(new Date());
	    
	    log.info(budget.toString());
	    
	    
	    // Extract the relevant parts of the composite key
	    String monthYear = budget.getBudgetManager().getIds().getMonthYear();
	    Long userId = budget.getBudgetManager().getIds().getUserId();
	    
	    log.warn(monthYear);
	    log.warn(Long.toString(userId));

	    // Create the composite key object
	    BudgetMangerIds budgetManagerIds = new BudgetMangerIds();
	   
	    budgetManagerIds.setMonthYear(monthYear);
	    budgetManagerIds.setUserId(userId);
	    
	    log.warn(budgetManagerIds.toString());
	   

	    // Find the BudgetManager using the composite key
	    Optional<BudgetManager> buOptional = budgetManagerRepository.findById(budgetManagerIds);
	    
	    

	    Budget bg;
	    if (buOptional.isPresent()) {
	        // If BudgetManager exists, save the budget
	        bg = budgetRepository.save(budget);
	    } else {
	        // If BudgetManager doesn't exist, create and save a new one
	        BudgetManager budgetManager = new BudgetManager();
	        
	        budgetManager.setIds(budgetManagerIds);
	        
	        //budgetManager.getIds().setMonthYear(monthYear);
	       // budgetManager.getIds().setUserId(userId);
	        budgetManagerRepository.save(budgetManager);

	        // Save the budget after the BudgetManager is saved
	        bg = budgetRepository.save(budget);
	    }

	    return bg;
	}
	
	
	
	


}
