package com.org.bhanu.expenseservice.entity.split;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.org.bhanu.expenseservice.enums.GroupStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "split-group")
public class Group {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String groupName;
	private double amount;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "group",fetch = FetchType.EAGER)
	private List<GroupMember> groupMembers = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	private GroupStatus status;
	private Long userId;
	
	private int payedMembers;
	
	private String grpPurpose;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	
	
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Group group = (Group) o;
	        return Objects.equals(id, group.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }
}
