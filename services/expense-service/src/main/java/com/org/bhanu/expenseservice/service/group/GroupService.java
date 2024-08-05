package com.org.bhanu.expenseservice.service.group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.split.Group;
import com.org.bhanu.expenseservice.entity.split.GroupMember;
import com.org.bhanu.expenseservice.enums.GroupStatus;
import com.org.bhanu.expenseservice.enums.PaymentStatus;
import com.org.bhanu.expenseservice.repository.group.GroupMemberRepository;
import com.org.bhanu.expenseservice.repository.group.GroupRepository;
import com.org.bhanu.expenseservice.request.GroupRequest;

@Service
public class GroupService {

	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private GroupMemberRepository memberRepository;

//	@Autowired
//	private GroupMemberService memberService;

	public String createGroup(GroupRequest groupRequest) {

		Group group = new Group();

		double share = groupRequest.getAmount() / groupRequest.getMemberIds().size();

		Set<GroupMember> members = new HashSet<>();

		group.setGroupName(groupRequest.getGroupName());
		group.setAmount(groupRequest.getAmount());
		group.setUserId(groupRequest.getUserId());

		List<GroupMember> groupMembers  = new ArrayList<>();
//		= groupRequest.getMemberIds().stream().map(id -> {
//
//			GroupMember member = new GroupMember();
//			member.setUserId(id);
//			member.setShareAmount(share);
//
//			member.setPaymentStatus(PaymentStatus.PENDING);
//			members.add(member);
//			member.setGroup(group);
//			return member;
//			
//		}).collect(Collectors.toSet());
		
		List<Long> memberids = groupRequest.getMemberIds();
		
		for(int i=0;i<memberids.size();i++) {
			GroupMember member = new GroupMember();
			
			
			member.setUserId(memberids.get(i));
			member.setShareAmount(share);

			member.setPaymentStatus(PaymentStatus.PENDING);
			members.add(member);
			member.setGroup(group);
			
			groupMembers.add(member);
		}
		
		group.setGroupMembers(groupMembers);
		group.setStatus(GroupStatus.PENDING);
		groupRepository.save(group);
		return "Group was created and sent request to group members";
	}
	
	
	
	public List<Group> getAllGroups(){
		
		
		System.out.println("insdiee");
		
		return groupRepository.findAll();
	}
	
	
	public List<Group> getAllGroupsOfUser(Long userId){
		return groupRepository.findAllByUserId(userId);
	}
	
	public List<Group>  getGroupsForMember(Long memberId) {
		System.out.println("get groups of member");
	 return memberRepository.findGroupsByMemberId(memberId);
	}
	
	
	public GroupMember getGM(Long memberId) {
		return memberRepository.findById(memberId).get();
	}
	
	

}
