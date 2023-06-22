package com.example.sqlstoredprocedure.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contract")
@NamedStoredProcedureQuery(
        name = "contractCreate",
        procedureName = "contract_create",
        parameters = {
        		@StoredProcedureParameter(name = "p_customer_id", mode = ParameterMode.IN, type = Integer.class),
                @StoredProcedureParameter(name = "p_contract_name", mode = ParameterMode.IN, type = String.class),
        }
)
@NamedStoredProcedureQuery(
        name = "contractGetAll",
        procedureName = "contract_get_all",
        resultClasses = Contract.class
)
@NamedStoredProcedureQuery(
        name = "contractGetById",
        procedureName = "contract_get_by_id",
        parameters = {
                @StoredProcedureParameter(name = "p_contract_id", mode = ParameterMode.IN, type = Long.class)
        },
        resultClasses = Contract.class
)
@NamedStoredProcedureQuery(
        name = "contractDelete",
        procedureName = "contract_delete",
        parameters = {
                @StoredProcedureParameter(name = "p_contract_id", mode = ParameterMode.IN, type = Long.class)
        }
        )
@NamedStoredProcedureQuery(
        name = "contractUpdate",
        procedureName = "contract_update",
        parameters = {
                @StoredProcedureParameter(name = "p_contract_id", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name = "p_contract_name", mode = ParameterMode.IN, type = String.class)
        }
)
public class Contract {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "contract_id")
	    private Long contractId;
	   
	    @ManyToOne(fetch = FetchType.EAGER, optional = false)
	    @JoinColumn(name = "customer_id", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private Customer customer;
	    
	    @Column(name = "contract_name")
	    private String contractName;
	    
	    
	    @Column(name = "status", columnDefinition = "CHAR(1) DEFAULT 'P' CHECK (status IN ('A', 'P'))")
	    private char status;
	    @Column(columnDefinition = "int default 1")
	    private int version;
	    @Column(updatable = false)
	    private LocalDateTime createdDate;

	    private LocalDateTime modifiedDate;
	    
	    @PrePersist
	    protected void onCreate() {
	        createdDate = LocalDateTime.now();
	        modifiedDate = LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        modifiedDate = LocalDateTime.now();
	    }

}
