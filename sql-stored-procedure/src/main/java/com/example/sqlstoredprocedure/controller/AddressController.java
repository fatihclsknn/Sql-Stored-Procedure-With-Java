package com.example.sqlstoredprocedure.controller;

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

import com.example.sqlstoredprocedure.service.AdressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import com.example.sqlstoredprocedure.entity.Address;

@RestController
@Tag(name = "Address")
public class AddressController {
	@Autowired
	private AdressService addressService;

	@GetMapping("/address")
	@Operation(summary = "list the addres")
	public ResponseEntity<List<Address>> getAllAddress() {
		List<Address> address = addressService.getAllAddress();

		return ResponseEntity.ok().body(address);
	}

	@PostMapping("/address")
	@Operation(summary = "add a address")
	public ResponseEntity<Void> addCustomer(@RequestBody Address address) {
		addressService.createAddres(address.getCustomer().getCustomerID(), 
				address.getCountryName(), address.getCityName());

        return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("address/{id}")
	@Operation(summary = "get a addres")

	public ResponseEntity<Address> getAddress(@PathVariable("id") Long id) {
		Address addres = addressService.getAddress(id);
		if (addres != null) {
			return ResponseEntity.ok(addres);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("address/{id}")
	@Operation(summary = "delete a address")

	public ResponseEntity<String> deleteAddress(@PathVariable("id") Long id) {
		addressService.deleteAdress(id);
		return ResponseEntity.ok("Address deleted successfully");
	}
	@PutMapping("address/{id}")
	@Operation(summary = "update a address")

	 public ResponseEntity<String> updateAccount(@PathVariable("id") Long addressId, @RequestBody Address address) {
	
		Address updatedAddres = addressService.updateAddres(addressId, address);
		if(updatedAddres != null)
		{
	         return ResponseEntity.ok("Addres with ID " + addressId + " updated successfully.");
		}
		  else
		     {
		         return ResponseEntity.notFound().build();

		     }
	}


	
}




