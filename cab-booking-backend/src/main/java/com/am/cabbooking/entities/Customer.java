package com.am.cabbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer extends AbstractUser {
	
	@Id
	@GeneratedValue
	private int customerId;
	
	public Customer() {
		// Default Constructor
	}

	// Parameterized Constructor
	public Customer(String username, String password, String address, String mobileNumber, String email) {
		super(username, password, address, mobileNumber, email);
	}
	
	// Getters and Setters
	public int getCustomerId() {
		return this.customerId;
	}
}
