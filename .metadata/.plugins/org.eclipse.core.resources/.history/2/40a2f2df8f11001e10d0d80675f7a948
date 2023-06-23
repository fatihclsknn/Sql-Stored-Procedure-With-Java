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

import com.example.sqlstoredprocedure.entity.Contract;
import com.example.sqlstoredprocedure.service.ContractService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Contracts")
public class ContractController {
	@Autowired
	private ContractService contractService;

	
	@PostMapping("/contracts")
	@Operation(summary = "add the contract")
	public ResponseEntity<Void> createContract(@RequestBody Contract contract)
	{
		contractService.createContract(contract.getCustomer().getCustomerID(), contract.getContractName());
	        return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/contracts")
	@Operation(summary = "list the contract	")
	public ResponseEntity<List<Contract>> getAllContract()
	{
		return ResponseEntity.ok().body(contractService.getAllContract());
	}
	@GetMapping("/contracts/{id}")
	@Operation(summary = "get a contract	")
	public ResponseEntity<Contract> getContract(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(contractService.getContract(id));
	}
	
	@DeleteMapping("contracts/{id}")
	@Operation(summary = "delete a contracts")

    public ResponseEntity<String> deleteContract(@PathVariable("id") Long id) {
	 	contractService.deleteContract(id);
        return ResponseEntity.ok("Contract deleted successfully");
    }
	
	
	@PutMapping("contracts/{id}")
	@Operation(summary = "update a contracts")

	 public ResponseEntity<String> updateContract(@PathVariable("id") Long contractId, @RequestBody Contract contract) {
	
		Contract updatedContract = contractService.updateContract(contractId, contract);
		if(updatedContract != null)
		{
	         return ResponseEntity.ok("Addres with ID " + contractId + " updated successfully.");
		}
		  else
		     {
		         return ResponseEntity.notFound().build();

		     }
	}
	
	
}
