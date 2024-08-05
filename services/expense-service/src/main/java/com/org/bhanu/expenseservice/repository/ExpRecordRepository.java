package com.org.bhanu.expenseservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.ExpRecord;

@Repository
public interface ExpRecordRepository extends JpaRepository<ExpRecord, Long> {
	
	
	List<ExpRecord> findAllByUserId(Long userId);

}
