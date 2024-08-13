package com.org.bhanu.expenseservice.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@IdClass(BudgetMangerIds.class)
public class BudgetManager {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	
//
//	private String monthYear;
//	
//	private Long userId;
	@EmbeddedId
	private BudgetMangerIds ids;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "budgetManager" , fetch = FetchType.EAGER)
	private List<Budget> budgets;

}
