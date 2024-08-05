package com.org.bhanu.expenseservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.ExpCategory;

@Repository
public interface ExpCategoryRepository extends JpaRepository<ExpCategory, Long> {
	
	
	List<ExpCategory> findAllByUserId(Long userId);

}
