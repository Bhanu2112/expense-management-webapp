package com.org.bhanu.expenseservice.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
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
	
	@JsonBackReference
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="monthYear",referencedColumnName = "monthYear"),
		@JoinColumn(name = "userId",referencedColumnName = "userId")
	})
	private BudgetManager budgetManager;
}
