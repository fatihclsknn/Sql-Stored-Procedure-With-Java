package com.example.sqlstoredprocedure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sqlstoredprocedure.entity.Account;




@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	 @Procedure(name = "Account.getAll")
	    List<Account> getAllAccounts();
	 @Procedure(name = "Account.delete")
	    void deleteAccount(@Param("p_accountID") Long customerID);
	 @Procedure(name = "Account.get")
	    Account getAccount(@Param("p_accountID") Long accountID);
	 @Procedure(name = "Account.update")
	  Account updateAccount(Long id, @RequestBody Account account);
	  @Procedure(name = "createAccount")
	    void createAccount(@Param("p_customerId") Long customerId, @Param("p_status") char status);
	    
}