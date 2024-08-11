package com.org.bhanu.expenseservice.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BudgetManager {
	
	@Id
	private String monthAndYear;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "budgetManager" , fetch = FetchType.EAGER)
	
	private List<Budget> budgets;

}
