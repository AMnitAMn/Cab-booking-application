package com.am.cabbooking.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.am.cabbooking.entities.TripBooking;
import com.am.cabbooking.exception.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class IAdminDaoImpl implements IAdminDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException {
		
		TypedQuery<TripBooking> query = em.createQuery("select tb from TripBooking tb where tb.customer.customerId=:cId",
				TripBooking.class);
		
		query.setParameter("cId", customerId);
		
		List<TripBooking> result = query.getResultList();
		
		return result;
	}

	@Override
	public List<TripBooking> getTripsCabwise() {
		
		TypedQuery<TripBooking> query = em.createQuery("select tb from TripBooking tb", TripBooking.class);
		
		List<TripBooking> trips = query.getResultList();
		
		trips = trips.stream()
				.sorted((a, b) -> a.getDriver().getCab().getCabId() - b.getDriver().getCab().getCabId())
				.collect(Collectors.toList());
		
		return trips;
	}

	@Override
	public List<TripBooking> getTripsCustomerwise() {
		
		TypedQuery<TripBooking> query = em.createQuery("select tb from TripBooking tb", TripBooking.class);
		
		List<TripBooking> trips = query.getResultList();
		
		trips = trips.stream()
				.sorted((a, b) -> a.getCustomer().getCustomerId() - b.getCustomer().getCustomerId())
				.collect(Collectors.toList());
		
		return trips;
	}

	@Override
	public List<TripBooking> getTripsDatewise() {
		
		TypedQuery<TripBooking> query = em.createQuery("select tb from TripBooking tb", TripBooking.class);
		
		List<TripBooking> trips = query.getResultList();
		
		trips = trips.stream()
				.sorted((a, b) -> a.getFromDateTime().compareTo(b.getFromDateTime()))
				.collect(Collectors.toList());
				
		return trips;
		
	}

	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException {
		
		TypedQuery<TripBooking> query = em.createQuery("select tb from TripBooking tb where tb.customer.customerId =: cId and tb.fromDateTime between :start and :end",
				                                        TripBooking.class);
		
		query.setParameter("cId", customerId);
		query.setParameter("start", fromDate);
		query.setParameter("end", toDate);
		
		List<TripBooking> trips = query.getResultList();
		
		return trips;
		
	}
		
}
