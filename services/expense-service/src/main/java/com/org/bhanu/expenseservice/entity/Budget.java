package com.org.bhanu.expenseservice.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String categoryName;
	private double budgetAmount;
	private Long catId;
	private double spent;
	
	private Date createdAt;
	private Date updateAt;
	
	@ManyToOne
	@JoinColumn(name="budgetmanager_id")
	private BudgetManager budgetManager;
}
