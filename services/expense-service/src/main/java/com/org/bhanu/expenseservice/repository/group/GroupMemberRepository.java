package com.org.bhanu.expenseservice.repository.group;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.org.bhanu.expenseservice.entity.split.Group;
import com.org.bhanu.expenseservice.entity.split.GroupMember;
@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long>{
	@Query("SELECT g FROM Group g JOIN g.groupMembers gm WHERE gm.userId = :memberId")
    List<Group> findGroupsByMemberId(@Param("memberId") Long memberId);

}
