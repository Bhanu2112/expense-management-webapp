package com.org.bhanu.expenseservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.bhanu.expenseservice.entity.Account;
import com.org.bhanu.expenseservice.entity.ExpRecord;
import com.org.bhanu.expenseservice.response.AccountResponse;
import com.org.bhanu.expenseservice.service.AccountService;

@RestController
public class AccountController {
	
	
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome to account controller";
	}
	
	@PostMapping("/create/account")
	public Account createAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}
	
	
	@GetMapping("/accounts/{userId}")
	public List<Account> getAllAccounts(@PathVariable Long userId)
	{
		return accountService.getAllAcountsOfUser(userId);
	}
	
	@GetMapping("/accounts/user/{userId}")
	public Map<String, List<ExpRecord>> getAllAccountsWithRecords(@PathVariable Long userId)
	{
		return accountService.getAllAcountsOfUserWithExpRecords(userId);
	}

}
