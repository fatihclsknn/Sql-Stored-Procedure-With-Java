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
@Table(name = "Account")
@NamedStoredProcedureQuery(
	    name = "Account.getAll",
	    procedureName = "getAllAccounts",
	    resultClasses = Account.class
	)
@NamedStoredProcedureQuery(
	    name = "Account.delete",
	    procedureName = "delete_account",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_accountID", type = Long.class)
	    }
	)
@NamedStoredProcedureQuery(
	    name = "Account.get",
	    procedureName = "get_account",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_accountID", type = Long.class)
	    },
	    resultClasses = Account.class
	)
@NamedStoredProcedureQuery(
	    name = "Account.update",
	    procedureName = "update_account",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_accountID", type = Integer.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_customerID", type = Integer.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_status", type = Character.class)
	    }
	)
@NamedStoredProcedureQuery(
	    name = "createAccount",
	    procedureName = "create_account",
	    parameters = {
	        @StoredProcedureParameter(name = "p_customerId", type = Integer.class, mode = ParameterMode.IN),
	        @StoredProcedureParameter(name = "p_status", type = Character.class, mode = ParameterMode.IN)
	    }
	)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountID")
    private Long accountId;

   
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;

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
