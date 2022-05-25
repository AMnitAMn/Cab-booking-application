package com.am.cabbooking.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Driver extends AbstractUser {
	
	@Id
	@GeneratedValue
	private int driverId;
	
	private String licenceNo;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cab_id")
	private Cab cab;
	
	private float rating;
	
	public Driver(){
		//Default Constructor
	}

	//Parameterized Constructor
	public Driver(String username, String password, String address, String mobileNumber, String email, String licenceNo, Cab cab, float rating) {
		super(username, password, address, mobileNumber, email);
		this.licenceNo = licenceNo;
		this.cab = cab;
		this.rating = rating;
	}

	//Getters and Setters
	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getDriverId() {
		return driverId;
	}
	
}
