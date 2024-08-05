package com.org.bhanu.expenseservice.entity.split;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.org.bhanu.expenseservice.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userId;
	private double shareAmount;
	private PaymentStatus paymentStatus;
	private String paymentMode;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="group_id",nullable = false)
	private Group group;
	
	
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupMember that = (GroupMember) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
	

}
