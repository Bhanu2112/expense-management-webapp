package com.org.bhanu.expenseservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.ExpRecord;

@Repository
public interface ExpRecordRepository extends JpaRepository<ExpRecord, Long> {
	
	
	List<ExpRecord> findAllByUserId(Long userId);
	
	 @Query("SELECT e FROM ExpRecord e WHERE MONTH(e.date) = :month AND YEAR(e.date) = :year AND e.userId = :memberId")
	    List<ExpRecord> findByMonthAndYear(@Param("month") int month, @Param("year") int year, @Param("memberId") Long memberId);

}
