package com.am.cabbooking.service;

import java.util.List;

import com.am.cabbooking.exception.DriverNotFoundException;
import com.am.cabbooking.entities.Driver;

public interface IDriverService {
	public List<Driver> displayAllDriver();

	public Driver viewDriver(int driverId) throws DriverNotFoundException;

	public List<Driver> viewBestDrivers() throws DriverNotFoundException;

	public List<Driver> insertDriver(Driver driver);
	
	public List<Driver> getDriverByCarType(String carType) throws DriverNotFoundException;

	public Driver updateDriver(Driver driver) throws DriverNotFoundException;

	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException;

}