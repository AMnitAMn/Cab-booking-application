package com.am.cabbooking.dao;

import java.util.List;

import com.am.cabbooking.entities.TripBooking;

public interface ITripBookingDao {
	
	public List<TripBooking> viewAllTripsCustomer(int customerId);
	
	public float calculateBill(int customerId);
	
	public List<TripBooking> viewAllTripsById(int tripbookingId);
	
}
