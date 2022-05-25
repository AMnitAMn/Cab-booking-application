package com.am.cabbooking.dao;

import java.util.List;

import com.am.cabbooking.entities.Cab;
import com.am.cabbooking.exception.CabNotFoundException;

public interface ICabDao {
	
	public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
	
	public int countCabsOfType(String carType) throws CabNotFoundException;
}
