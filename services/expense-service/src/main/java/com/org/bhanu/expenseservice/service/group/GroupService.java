package com.org.bhanu.expenseservice.service.group;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.dao.RequestsAndSettlementDAO;
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

	/*
	 * The `createGroup` method initializes a new `Group` entity and calculates each
	 * member's share amount based on the total amount and number of members. It
	 * creates `GroupMember` entities for each member ID provided, sets their
	 * details (user ID, share amount, payment status), and associates them with the
	 * group. The method then assigns the list of members to the group, sets the
	 * group status to `PENDING`, and saves the group to the repository. Finally, it
	 * returns a success message indicating that the group was created and requests
	 * were sent to the members.
	 */

	public String createGroup(GroupRequest groupRequest) {

		Group group = new Group();

		double share = groupRequest.getAmount() / groupRequest.getMemberIds().size();

		Set<GroupMember> members = new HashSet<>();

		group.setGroupName(groupRequest.getGroupName());
		group.setAmount(groupRequest.getAmount());
		group.setUserId(groupRequest.getUserId());

		group.setPayedMembers(1);

		List<GroupMember> groupMembers = new ArrayList<>();

		List<Long> memberids = groupRequest.getMemberIds();

		for (int i = 0; i < memberids.size(); i++) {
			GroupMember member = new GroupMember();

			if (memberids.get(i) == group.getUserId()) {
				member.setPaymentStatus(PaymentStatus.COMPLETED);
			} else {
				member.setPaymentStatus(PaymentStatus.PENDING);
			}
			member.setUserId(memberids.get(i));
			member.setShareAmount(share);

			members.add(member);
			member.setGroup(group);

			groupMembers.add(member);
		}

		group.setGroupMembers(groupMembers);
		group.setStatus(GroupStatus.PENDING);
		groupRepository.save(group);
		return "Group was created and sent request to group members";
	}

	public Group findGroup(Long groupId) {
		return groupRepository.findById(groupId).get();
	}

	public List<Group> getAllGroups() {

		return groupRepository.findAll();
	}

	public List<Group> getAllGroupsOfUser(Long userId) {
		return groupRepository.findAllByUserId(userId);
	}

	public List<Group> getGroupsForMember(Long memberId) {
		return memberRepository.findGroupsByMemberId(memberId);
	}

	public GroupMember getGM(Long memberId) {
		return memberRepository.findById(memberId).get();
	}

	public List<RequestsAndSettlementDAO> getAllRequestsAndSettlements(Long memberId) {

		List<Group> memberGroups = getGroupsForMember(memberId);

		List<RequestsAndSettlementDAO> andSettlementDAOs = new ArrayList<>();

		for (Group g : memberGroups) {
			RequestsAndSettlementDAO settlementDAO = new RequestsAndSettlementDAO();

			if (g.getUserId() == memberId) {
				
				double pendingAmount =	g.getGroupMembers().stream()
							.filter(gm -> gm.getPaymentStatus().equals(PaymentStatus.PENDING))
							.mapToDouble(GroupMember::getShareAmount)
							.sum();
			settlementDAO.setGroupId(g.getId());
			settlementDAO.setType("Settlement");
			settlementDAO.setMessage(String.format("%.2f", pendingAmount)  +" pending settlement in "+g.getGroupName());
			andSettlementDAOs.add(settlementDAO);

			} else {

				
				GroupMember gm = g.getGroupMembers().stream().filter(gm1 -> gm1.getUserId()==memberId).findFirst().orElse(null);
				if(gm.getPaymentStatus().equals(PaymentStatus.PENDING) && gm!=null) {
					settlementDAO.setGroupId(g.getId());
					settlementDAO.setType("Request");
					settlementDAO.setMessage(String.format("%.2f",gm.getShareAmount()) +" requested from "+g.getGroupName());
					andSettlementDAOs.add(settlementDAO);
				}
			}

		}

		return andSettlementDAOs;
	}

}
