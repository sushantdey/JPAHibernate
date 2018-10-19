package com.cg.banking.beans;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int CustomerId;
	private String mobileNo, aadharNo ;
	private String firstName, lastName , emailId, pancard, dateOfBirth;
	@ManyToOne
	private Customer customer;
	@OneToMany(mappedBy="account")
	private List<Transaction> transactions;
	public Account() {
		super();
	}
	
}
