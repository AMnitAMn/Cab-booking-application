package com.am.cabbooking.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
public class TripBooking {
	
	@Id
	@GeneratedValue
	private int tripBookingId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;
	
	private String fromLocation;
	private String toLocation;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime fromDateTime;
	
	private LocalDateTime toDateTime;
	
	private boolean status;
	private float distanceInKm;
	
	public TripBooking() {
		// Default Constructor
	}

	// Parameterized Constructor
	public TripBooking(Customer customer, Driver driver, String fromLocation, String toLocation, LocalDateTime fromDateTime,
			LocalDateTime toDateTime, boolean status, float distanceInKm) {
		this.customer = customer;
		this.driver = driver;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.fromDateTime = fromDateTime;
		this.toDateTime = toDateTime;
		this.status = status;
		this.distanceInKm = distanceInKm;
	}
	

	// Getters and Setters
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	
	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public LocalDateTime getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(LocalDateTime fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public LocalDateTime getToDateTime() {
		return toDateTime;
	}

	public void setToDateTime(LocalDateTime toDateTime) {
		this.toDateTime = toDateTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public float getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(float distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public int getTripBookingId() {
		return tripBookingId;
	}
}
