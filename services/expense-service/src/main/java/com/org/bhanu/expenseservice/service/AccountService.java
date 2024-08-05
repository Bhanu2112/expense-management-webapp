package com.org.bhanu.expenseservice.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.bhanu.expenseservice.entity.Account;
import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.repository.AccountRepository;
import com.org.bhanu.expenseservice.response.AccountResponse;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ExpRecordService recordService;

	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	@Transactional
	public List<Account> getAllAcountsOfUser(Long userId) {
		return accountRepository.findAllByUserId(userId);
	}

	public Map<String, List<ExpRecord>> getAllAcountsOfUserWithExpRecords(Long userId){
		
		
		List<ExpRecord> records =  recordService.findAllRecordsByUserId(userId);
		
		Map<String, List<ExpRecord>> recordsList = records.stream()
			.collect(Collectors.groupingBy(r -> r.getAccount().getAccountName(),Collectors.toList()));
		System.out.println(recordsList);
		
		
		return recordsList;
	}

}
