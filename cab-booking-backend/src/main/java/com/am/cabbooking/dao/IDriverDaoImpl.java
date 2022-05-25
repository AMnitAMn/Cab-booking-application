package com.am.cabbooking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.am.cabbooking.entities.Driver;
import com.am.cabbooking.exception.DriverNotFoundException;

public class IDriverDaoImpl implements IDriverDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Driver> viewBestDrivers() {
		
		TypedQuery<Driver> query = em.createQuery("select d from Driver d where  rating > 4.5", Driver.class);

		return query.getResultList();
	}

	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException {
		
		TypedQuery<Driver> query = em.createQuery("select d.driverId, d.licenceNo, d.rating from Driver d where driverId = :id", Driver.class);
		
		query.setParameter("id", driverId);

		return query.getSingleResult();
	}

	@Override
	public List<Driver> getDriverByCarType(String carType) throws DriverNotFoundException {
		
		TypedQuery<Driver> query = em.createQuery("select d from Driver d where d.cab.cabId in"
				                                + "(select c from Cab c where carType = :type)", Driver.class);
		
		query.setParameter("type", carType);

		return query.getResultList();
	}

}
