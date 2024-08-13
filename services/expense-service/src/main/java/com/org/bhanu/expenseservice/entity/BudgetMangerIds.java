package com.org.bhanu.expenseservice.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Embeddable
public class BudgetMangerIds implements Serializable {
	
	private String monthYear;
	private Long userId;

}
