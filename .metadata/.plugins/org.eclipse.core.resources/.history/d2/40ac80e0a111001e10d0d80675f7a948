package com.example.sqlstoredprocedure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.sqlstoredprocedure.entity.Contract;

import jakarta.transaction.Transactional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>{
	@Procedure(name = "contractCreate")
    void createContract(@Param("p_customer_id") Long customerId, 
    		@Param("p_contract_name") String contractName);
	@Procedure(name = "contractGetAll")
    List<Contract> getAllContract();
	@Procedure(name = "contractGetById")
	Contract getContract(@Param("p_contract_id") Long contractrId);
	 @Procedure(name = "contractDelete")
	    void deleteContract(@Param("p_contract_id") Long contractID);
	 
	  @Procedure(name = "contractUpdate")
	  Contract updateContract(Long id, @RequestBody Contract contract);
	  @Modifying
	    @Transactional
	    @Query(value = "CALL update_contract_status(:contractId)", nativeQuery = true)
	    void updateContractStatus(Long contractId);
}
