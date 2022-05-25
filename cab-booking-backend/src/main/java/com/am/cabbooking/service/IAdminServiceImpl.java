package com.am.cabbooking.service;

import java.time.LocalDateTime;
import java.util.List;

import com.am.cabbooking.entities.Admin;
import com.am.cabbooking.entities.TripBooking;
import com.am.cabbooking.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.cabbooking.repository.IAdminRepository;

@Service("ias")
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminRepository aDao;

	@Override
	public List<Admin> viewALlAdmin() {

		return aDao.findAll();
	}

	@Override
	public Admin insertAdmin(Admin admin) {
		aDao.saveAndFlush(admin);
		return admin;
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		aDao.saveAndFlush(admin);
		return admin;
	}

	@Override
	public List<Admin> deleteAdmin(int adminId) {
		aDao.deleteById(adminId);
		return aDao.findAll();
	}


	@Override
	public List<TripBooking> getAllTrips(int customerId) throws CustomerNotFoundException {
		return aDao.getAllTrips(customerId);
	}


	@Override
	public List<TripBooking> getTripsCabwise() {
		return aDao.getTripsCabwise();
	}


	@Override
	public List<TripBooking> getTripsCustomerwise() {
		return aDao.getTripsCustomerwise();
	}


	@Override
	public List<TripBooking> getTripsDatewise() {
		return aDao.getTripsDatewise();
	}


	@Override
	public List<TripBooking> getAllTripsForDays(int customerId, LocalDateTime fromDate, LocalDateTime toDate)
			throws CustomerNotFoundException {
		return aDao.getAllTripsForDays(customerId, fromDate, toDate);
	}


	@Override
	public Admin getAdminById(int adminId) {

		return aDao.findById(adminId).get();
	}

}