package com.org.bhanu.expenseservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.BudgetManager;
import com.org.bhanu.expenseservice.entity.BudgetMangerIds;

@Repository
public interface BudgetManagerRepository extends JpaRepository<BudgetManager, BudgetMangerIds> {
	
//	@Query("SELECT bm FROM BudgetManager bm WHERE bm.monthYear =:monthAndYear AND bm.userId =:userId")
//	BudgetManager findByMonthYearAndUserId(@Param("monthAndYear") String monthAndYear, @Param("userId") Long userId);
	//BudgetManager findByMonthYearAndUserId( String monthAndYear,  Long userId);


//	Optional<BudgetManager> findById(BudgetMangerIds budgetManagerIds);
	
	
	
//	BudgetManager findByUserId(Long userId);

}
