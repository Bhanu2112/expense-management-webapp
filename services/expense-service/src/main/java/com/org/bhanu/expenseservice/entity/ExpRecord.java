 package com.org.bhanu.expenseservice.entity;

import java.sql.Date;

import com.org.bhanu.expenseservice.enums.RecordType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExpRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount; 
	
	@Enumerated(EnumType.STRING)
	private RecordType recordType;
	
	private String reason;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private ExpCategory category;
	
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	private Long userId;
	
	private Date date;
	

}
