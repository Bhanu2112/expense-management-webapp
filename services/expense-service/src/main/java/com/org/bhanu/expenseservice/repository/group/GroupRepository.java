package com.org.bhanu.expenseservice.repository.group;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.split.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
	
	
	List<Group> findAllByUserId(Long userId);

}
