package com.org.bhanu.expenseservice.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupRequest {
	
	
	private String groupName;
	private double amount;
	private Long userId;
	private List<Long> memberIds;

}
