
package com.org.bhanu.expenseservice.service.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.org.bhanu.expenseservice.dao.AppUser;
import com.org.bhanu.expenseservice.repository.group.GroupMemberRepository;

public class GroupMemberService {
	
	@Autowired
	private GroupMemberRepository memberRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public AppUser checkUser(Long userId) {
		
	 AppUser user =	restTemplate.getForObject("http://user-service/user/finduser/"+userId, AppUser.class);
		
		return user;
	}

}
