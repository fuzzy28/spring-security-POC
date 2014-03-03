package com.acss.poc.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
	
	private IAccountRepository accountRepository;
	
	@Autowired
	public AccountService(IAccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
	
	public Account findByUsername(String username) {
		return accountRepository.findByUserName(username);
	}

}
