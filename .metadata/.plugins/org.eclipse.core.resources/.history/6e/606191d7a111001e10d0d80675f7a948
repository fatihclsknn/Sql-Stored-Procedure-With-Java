package com.example.sqlstoredprocedure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sqlstoredprocedure.entity.Branch;

import jakarta.transaction.Transactional;
@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
	 @Procedure(name = "Branch.create")
	    Branch addBranch(@Param("p_branch_name") String branchName, @Param("p_branch_location") String branchLocation, @Param("p_status") char status);

	 @Procedure(name = "Branch.getAll")
	 List<Branch> getAllBranch();
	 
	 @Procedure(name = "Branch.get")
	 Branch getBranch(@Param("p_branch_id") Long branchId);
 	 
	/* @Procedure(name = "Branch.delete")
	    void deleteBranch(@Param("p_branch_id") Long customerID);
	 */
	 @Procedure(name = "Branch.update")
	  Branch updateAddres(Long id, @RequestBody Branch branch);
	 
	    @Modifying
	    @Transactional
	    @Query(value = "CALL update_branch_status(:branchId)", nativeQuery = true)
	    void updateBranchStatus(Long branchId);
}
