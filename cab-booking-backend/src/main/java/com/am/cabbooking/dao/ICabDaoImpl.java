package com.am.cabbooking.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.am.cabbooking.entities.Cab;
import com.am.cabbooking.exception.CabNotFoundException;

public class ICabDaoImpl implements ICabDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException {
		
		TypedQuery<Cab> query = em.createQuery("select c from Cab c where carType = :type", Cab.class);
		
		query.setParameter("type", carType);

		return query.getResultList();
	}

	@Override
	public int countCabsOfType(String carType) throws CabNotFoundException {
		
		List<Cab> lisCabs = viewCabsOfType(carType);
		
		return lisCabs.size();
	}

}
