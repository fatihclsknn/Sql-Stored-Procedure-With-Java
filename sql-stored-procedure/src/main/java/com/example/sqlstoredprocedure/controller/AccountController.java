package com.example.sqlstoredprocedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sqlstoredprocedure.entity.Account;
import com.example.sqlstoredprocedure.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	@Operation(summary = "list the accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accounts = accountService.getAllAccounts();
	 
		return ResponseEntity.ok(accounts);
	}
	
	
	@PostMapping("/accounts")
	@Operation(summary = "add the accounts")
    public ResponseEntity<Void> createAccount(@RequestBody Account account) {
        accountService.createAccount(account.getCustomer().getCustomerID(), account.getStatus());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	
	
	/* @DeleteMapping("accounts/{id}")
		@Operation(summary = "delete a account")

	    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id) {
		 accountService.deleteAccount(id);
	        return ResponseEntity.ok("Account deleted successfully");
	    }
	    */
	  @GetMapping("accounts/{id}")
		@Operation(summary = "get a customer")

	    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
	        Account account = accountService.getAccount(id);
	        if (account != null) {
	            return ResponseEntity.ok(account);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	  
	   @PutMapping("accounts/{id}")
	    public ResponseEntity<String> updateAccount(@PathVariable("id") Long accountId, @RequestBody Account account) {

	        Account updatedAccount = accountService.updateAccount(accountId, account);
	        if (updatedAccount != null)
	        {
	            return ResponseEntity.ok("Account with ID " + accountId + " updated successfully.");
	        }
	        else
	        {
	            return ResponseEntity.notFound().build();

	        }
	    }
	   
	   @DeleteMapping("/accounts/{id}")
		@Operation(summary = "delete a account")
	    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
	        boolean updateSuccess = accountService.updateAccountStatus(id);
	        if (updateSuccess) {
	            return ResponseEntity.ok("Account deleted successfully.");
	        } else {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete account.");
	        }
	    }
	

}

