package com.org.bhanu.expenseservice.dao;

import java.util.List;

import com.org.bhanu.expenseservice.entity.split.Group;

import lombok.Data;

@Data
public class InvolvedGroups {
	
	private List<Group> activeGroups;
	private List<Group> closedGroups;

}
