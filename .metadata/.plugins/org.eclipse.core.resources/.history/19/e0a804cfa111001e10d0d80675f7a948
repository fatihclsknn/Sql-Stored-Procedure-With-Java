package com.example.sqlstoredprocedure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sqlstoredprocedure.entity.Account;
import com.example.sqlstoredprocedure.repository.AccountRepository;


import jakarta.transaction.Transactional;
@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Transactional 
	 public List<Account> getAllAccounts() {

	        return accountRepository.getAllAccounts();
	    }
	
	/* @Transactional
	  public void deleteAccount(Long id) {
		 accountRepository.deleteAccount(id);
	    }
	    */
	 @Transactional
	  public Account getAccount(Long id) {
	       return accountRepository.getAccount(id);
	    }
	
	 @Transactional
	 public Account updateAccount(Long id, @RequestBody Account account) {
		    Account updateAccount = accountRepository.getAccount(id);
		    if(updateAccount != null)
		    {
		    	updateAccount.setStatus(account.getStatus());
		    	updateAccount.setCustomer(account.getCustomer());
		    	return updateAccount;
		    }
		    else
		    	return null;
		}
	 @Transactional
	  public void createAccount(Long customerId, char status) {
	        accountRepository.createAccount(customerId, status);
	    }
	 public boolean updateAccountStatus(Long accountId) {
	        try {
	            accountRepository.updateAccountStatus(accountId);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 
}




