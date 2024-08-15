package com.org.bhanu.expenseservice.dao;

import java.util.List;

import com.org.bhanu.expenseservice.entity.split.Group;

import lombok.Data;

@Data
public class GroupsDTO {
	
	private Long userId;
	private List<Group> myGroups;
	private List<InvolvedGroups> involvedGroups;
	

}
