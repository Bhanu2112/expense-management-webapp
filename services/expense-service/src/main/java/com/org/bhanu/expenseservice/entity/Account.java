package com.org.bhanu.expenseservice.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String accountName;
	
	private Long userId;
	
	private double balance;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account" , fetch = FetchType.EAGER)
	private Set<ExpRecord> expRecords;
	
	
	

}
