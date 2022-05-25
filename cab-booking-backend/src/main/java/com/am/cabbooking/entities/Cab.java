package com.am.cabbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cab {
	
	@Id
	@GeneratedValue
	private int cabId;
	
	private String carType;
	private float perKmRate;
	
	public Cab() {
		//Default Constructor
	}
	
	//Parameterized Constructor
	public Cab(String carType, float perKmRate) {
		this.carType = carType;
		this.perKmRate = perKmRate;
	}

	//Getters and Setters
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public float getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}

	public int getCabId() {
		return cabId;
	}

}
