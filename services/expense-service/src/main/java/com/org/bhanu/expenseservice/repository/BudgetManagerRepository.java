package com.org.bhanu.expenseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.BudgetManager;

@Repository
public interface BudgetManagerRepository extends JpaRepository<BudgetManager, String> {

}
