package com.org.bhanu.expenseservice.response;

import java.util.Set;

import com.org.bhanu.expenseservice.entity.ExpRecord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
	
	private Long id;
	
	private String accountName;
	
	private Long userId;
	
	private double balance;
	
	
	private Set<ExpRecord> expRecords;
}
