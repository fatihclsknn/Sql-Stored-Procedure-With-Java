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

import com.example.sqlstoredprocedure.entity.Branch;
import com.example.sqlstoredprocedure.service.BranchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name ="Branches")
public class BranchController {
	@Autowired
	private BranchService branchService;
	@PostMapping("/branches")
	@Operation(summary = "add a branch")
	public ResponseEntity<Branch> addBranch(@RequestBody Branch branch)
	{
		Branch newBranch = branchService.addBranch(branch.getBranchName(), branch.getBranchLocation(),branch.getStatus());
		return ResponseEntity.ok().body(newBranch);
	}
	@GetMapping("/branches")
	@Operation(summary = "get the branches")
	public ResponseEntity<List<Branch>> getAllBranch()
	{
		return ResponseEntity.ok().body(branchService.getAllBranch());
	}
	@GetMapping("/branches/{id}")
	@Operation(summary = "get the branch")
	public ResponseEntity<Branch> getBranch(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(branchService.getBranch(id));
	}
	
	/*@DeleteMapping("/branches/{id}")
	@Operation(summary = "delete a branch")
	public ResponseEntity<String> deleteBranch(@PathVariable Long id)
	{
		branchService.deleteBranch(id);
		return ResponseEntity.ok("Branch deleted successfully");
	}
	*/
	@PutMapping("/branches/{id}")
	@Operation(summary = "update a branch")
	public ResponseEntity<Branch> updateBranch(@PathVariable Long id, @RequestBody Branch branch)
	{
		Branch updatedBranch = branchService.updateBranch(id, branch);
		if (updatedBranch != null)
		{
			return ResponseEntity.ok().body(updatedBranch);
		}
		else
		{
			return null;
		}
	}
	
	
	@DeleteMapping("/branches/{id}")
	@Operation(summary = "delete a branch")
    public ResponseEntity<String> deleteBranch(@PathVariable Long id) {
        boolean updateSuccess = branchService.updateBranchStatus(id);
        if (updateSuccess) {
            return ResponseEntity.ok("Branch  deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete branch.");
        }
    }

}
