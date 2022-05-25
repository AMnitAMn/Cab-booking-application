package com.am.cabbooking.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.am.cabbooking.entities.TripBooking;

public class ITripBookingDaoImpl implements ITripBookingDao{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<TripBooking> viewAllTripsCustomer(int customerId) {
		
		TypedQuery<TripBooking> query = em.createQuery(
				"select tb from TripBooking tb where tb.customer.customerId=:customerId", TripBooking.class);
		
		query.setParameter("customerId", customerId);
		
		List<TripBooking> result = query.getResultList();
		
		return result;
	}

	@Override
	public float calculateBill(int customerId) {
		
		TypedQuery<TripBooking> q = em.createQuery(
				"select tb from TripBooking tb where tb.customer.customerId=:customerId", TripBooking.class);
		
		q.setParameter("customerId", customerId);
		
		List<TripBooking> list = q.getResultList();
		
		Optional<Float> result = list.stream()
				                     .map((tb) -> tb.getDistanceInKm() * tb.getDriver().getCab().getPerKmRate())
				                     .reduce((a, b) -> a + b);
		
		return result.get();
	}
	
	@Override
	public List<TripBooking> viewAllTripsById(int tripbookingId) {
		
		TypedQuery<TripBooking> q = em.createQuery("select tb from TripBooking tb where tb.tripBookingId=:tripId",
				TripBooking.class);
		
		q.setParameter("tripId", tripbookingId);
		
		List<TripBooking> result = q.getResultList();
		
		return result;
	}

}
