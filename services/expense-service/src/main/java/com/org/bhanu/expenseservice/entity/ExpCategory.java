package com.org.bhanu.expenseservice.entity;

import java.util.Set;

import com.org.bhanu.expenseservice.enums.RecordType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ExpCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String categoryName;
	
	@Enumerated(EnumType.STRING)
	private RecordType categoryType;
	
	private Long userId;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category",fetch = FetchType.EAGER)
	private Set<ExpRecord> expRecords;

}
