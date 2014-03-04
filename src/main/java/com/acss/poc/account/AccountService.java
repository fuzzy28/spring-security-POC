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

	public Account saveOrUpdate(Account account) {
		//if user is no longer new then proceed with saving.
		if(!account.isNew()){
			Account existingUser = accountRepository.findByUserName(account.getUsername());
			account.setPassword(existingUser.getPassword());
		}
		//if account already exists then proceed with update.
		return accountRepository.save(account);
	}

}
