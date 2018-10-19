package com.cg.banking.beans;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int CustomerId;
	private String firstName, lastName, emailId, pancard, dateOfBirth,aadharNo, mobileNo;
	public Customer() {
		super();
	}
	@OneToMany(mappedBy="customer")
	private List<Account> accounts;
	@Embedded
	private Address address;
}
