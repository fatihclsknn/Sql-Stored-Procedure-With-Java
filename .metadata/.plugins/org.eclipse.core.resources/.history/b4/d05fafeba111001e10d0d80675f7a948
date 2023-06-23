package com.example.sqlstoredprocedure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sqlstoredprocedure.entity.Branch;
import com.example.sqlstoredprocedure.repository.BranchRepository;

import jakarta.transaction.Transactional;
@Service
public class BranchService {
	@Autowired
	private BranchRepository branchRepository;
	@Transactional
	public Branch addBranch(
			String branchName, String branchLocation, char status)
	{
		Branch branch = new Branch();
		branch.setBranchName(branchName);
		branch.setBranchLocation(branchLocation);
		branch.setStatus(status);
		return branchRepository.addBranch(branchName, branchLocation, status);
	}
	@Transactional
	public List<Branch> getAllBranch()
	{
		return branchRepository.getAllBranch();
	}
	@Transactional
	public Branch getBranch(Long branchId)
	{
		return branchRepository.getBranch(branchId);
	}
	/*@Transactional
	public void deleteBranch(Long branchId)
	{
		 branchRepository.deleteBranch(branchId);
	}
	*/
	
	 @Transactional
	 public Branch updateBranch(Long id, @RequestBody Branch branch ) {
	     Branch updateBranch = branchRepository.getBranch(id);
	     
	     if (updateBranch != null) {
	    	 updateBranch.setBranchLocation(branch.getBranchLocation());
	    	 updateBranch.setBranchName(branch.getBranchName());
	    	 updateBranch.setStatus(branch.getStatus());
	    	 
	         return updateBranch;
	     } else {
	         return null;
	     }
	 }
	
	 public boolean updateBranchStatus(Long branchId) {
	        try {
	            branchRepository.updateBranchStatus(branchId);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
	
	
}
