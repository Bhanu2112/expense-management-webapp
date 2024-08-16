package com.org.bhanu.expenseservice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestsAndSettlementDAO {
	private long groupId;
	private String message;
	private String type;
	
}
