package com.example.sqlstoredprocedure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sqlstoredprocedure.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import com.example.sqlstoredprocedure.entity.Address;
import com.example.sqlstoredprocedure.entity.Contract;
import com.example.sqlstoredprocedure.entity.Customer;

@RestController
@Tag(name = "Customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	 @GetMapping("/customers")
	@Operation(summary = "list the customers")

	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        List<Customer> customers = customerService.getAllCustomers();
	        return ResponseEntity.ok(customers);
	    }
	 
	 @GetMapping("/customers/{id}/address")
		@Operation(summary = "list the customer address")
	 public ResponseEntity<List<Address>> getCustomerAddress(@PathVariable("id") Long id) {
		 		List<Address> address = customerService.getCustomerAddress(id);
		        return ResponseEntity.ok(address);
		    }
	 @GetMapping("/customers/{id}/contract")
		@Operation(summary = "list the customer contract")
	 public ResponseEntity<List<Contract>> getCustomerContract(@PathVariable("id") Long id) {
		 		List<Contract> contract = customerService.getCustomerContract(id);
		        return ResponseEntity.ok(contract);
		    }

	
	 @PostMapping("/customers")
	@Operation(summary = "add a customer")
	    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		    Customer newCustomer = customerService.addCustomer(customer.getCustomerName(), customer.getCustomerSurname(), customer.getStatus());
		    return ResponseEntity.ok(newCustomer);
	    }
	 @GetMapping("customers/{id}")
		@Operation(summary = "get a customer")

	    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
	        Customer customer = customerService.getCustomer(id);
	        if (customer != null) {
	            return ResponseEntity.ok(customer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	 
	 @DeleteMapping("customers/{id}")
		@Operation(summary = "delete a customer")

	    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
		 	customerService.deleteCustomer(id);
	        return ResponseEntity.ok("Customer deleted successfully");
	    }
	    @PutMapping("customers/{id}")
		@Operation(summary = "update a customer")
	    public ResponseEntity<String> updateCustomer(
	            @PathVariable("id") Long id,
	            @RequestBody Customer customer) {
	        
	        Customer updatedCustomer = customerService.updateCustomer(id, customer);
	        
	        if (updatedCustomer != null) {
	            return ResponseEntity.ok("Customer with ID " + id + " updated successfully.");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	
	
	
}
