package com.org.bhanu.expenseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long>{

}
