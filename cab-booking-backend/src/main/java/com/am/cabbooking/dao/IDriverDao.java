package com.am.cabbooking.dao;

import java.util.List;

import com.am.cabbooking.entities.Driver;
import com.am.cabbooking.exception.DriverNotFoundException;

public interface IDriverDao {
	
	public List<Driver> viewBestDrivers();
	
	public Driver viewDriver(int driverId) throws DriverNotFoundException;
	
	public List<Driver> getDriverByCarType(String carType) throws DriverNotFoundException;
	
}
