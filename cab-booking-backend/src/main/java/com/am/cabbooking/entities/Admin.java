package com.am.cabbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractUser {
	
	@Id
	@GeneratedValue
	private int adminId;
	
	public Admin() {
		// Default Constructor
	}

	// Parameterized Constructor
	public Admin(String username, String password, String address, String mobileNumber, String email) {
		super(username, password, address, mobileNumber, email);
	}
	
	// Getters and Setters
	public int getAdminId() {
		return this.adminId;
	}
}
