package com.am.cabbooking.service;

import java.util.List;
import java.util.stream.Collectors;

import com.am.cabbooking.entities.Driver;
import com.am.cabbooking.exception.DriverNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.cabbooking.repository.IDriverRepository;

@Service("ids")
public class IDriverServiceImpl implements IDriverService {
	@Autowired
	IDriverRepository dDao;

	/**
	 * 
	 * @return List<Driver>
	 */
	@Override
	public List<Driver> displayAllDriver() {
		return dDao.findAll();
	}

	/**
	 * @param driverId
	 * @return Driver
	 * @throws DriverNotFoundException
	 */

	@Override
	public Driver viewDriver(int driverId) throws DriverNotFoundException {
		return dDao.findById(driverId).get();
	}

	/**
	 * @return List<Driver>
	 * @throws DriverNotFoundException
	 */

	@Override
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		List<Driver> bestDrivers = dDao.findAll();
		return bestDrivers.stream().filter((d) -> d.getRating() >= 4.5).collect(Collectors.toList());
	}

	/**
	 * @param driver
	 * @return List<Driver>
	 */

	@Override
	public List<Driver> insertDriver(Driver driver) {
		dDao.saveAndFlush(driver);
		return dDao.findAll();
	}

	/**
	 * @return Driver
	 * @param driver
	 * @throws DriverNotFoundException
	 */

	@Override
	public Driver updateDriver(Driver driver) throws DriverNotFoundException {

		return dDao.saveAndFlush(driver);
	}

	/**
	 * @param driverId
	 * @return List<Driver>
	 * @throws DriverNotFoundException
	 */

	@Override
	public List<Driver> deleteDriver(int driverId) throws DriverNotFoundException {
		dDao.deleteById(driverId);
		return dDao.findAll();
	}

	@Override
	public List<Driver> getDriverByCarType(String carType) throws DriverNotFoundException {
		return dDao.getDriverByCarType(carType);
	}

}
