package com.am.cabbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.am.cabbooking.dao.ITripBookingDao;
import com.am.cabbooking.entities.TripBooking;

@Repository("tbDao")
public interface ITripBookingRepository extends JpaRepository<TripBooking, Integer>, ITripBookingDao{
	
}