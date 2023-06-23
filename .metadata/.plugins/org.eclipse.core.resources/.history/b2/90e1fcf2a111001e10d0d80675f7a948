package com.example.sqlstoredprocedure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sqlstoredprocedure.entity.Contract;
import com.example.sqlstoredprocedure.repository.ContractRepository;

import jakarta.transaction.Transactional;

@Service
public class ContractService {
	@Autowired
	private ContractRepository contractRepository;
	@Transactional
	public void createContract(Long customerId, 
    		 String contractName)
	{
		contractRepository.createContract(customerId, contractName);
	}
	@Transactional
	public List<Contract> getAllContract()
	{
		return contractRepository.getAllContract();
	}
	@Transactional
	public Contract getContract(Long contractId)
	{
		return contractRepository.getContract(contractId);
	}
	@Transactional
	  public void deleteContract(Long id) {
		 contractRepository.deleteContract(id);
	    }
	
	
	 @Transactional
	 public Contract updateContract(Long id, @RequestBody Contract contract )
	 {
		 Contract updateContract = contractRepository.getContract(id);
		 if (updateContract != null)
		 {
			 updateContract.setContractName(contract.getContractName());
			 return updateContract;
		 }
		 else
		 {
			 return null;
		 }
	 }
	 
	 
	 @Transactional
	 public boolean updateContractStatus(Long contractId) {
	        try {
	        	contractRepository.updateContractStatus(contractId);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
}
