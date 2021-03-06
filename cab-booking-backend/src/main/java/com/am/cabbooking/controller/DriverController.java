package com.am.cabbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.am.cabbooking.entities.Driver;
import com.am.cabbooking.exception.DriverNotFoundException;
import com.am.cabbooking.exception.InvalidUserOrPasswordException;
import com.am.cabbooking.service.IDriverService;
import com.am.cabbooking.util.LoginService;

@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	IDriverService ids;

	@Autowired
	LoginService ls;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public Driver validateDriver(@RequestBody Driver driver) throws InvalidUserOrPasswordException {
		Driver response = null;
		try {
			response = (Driver) ls.validateCredintials(driver);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Username/Password");
		}
		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Driver> displayAllDrivers() {
		return ids.displayAllDriver();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{driverId}")
	public Driver viewDriver(@PathVariable int driverId) throws DriverNotFoundException {
		Driver driver = null;
		try {
			driver = ids.viewDriver(driverId);

		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Id: " + driverId + " Not Found!");
		}
		return driver;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/bestdrivers")
	public List<Driver> viewBestDrivers() throws DriverNotFoundException {
		List<Driver> lis = null;
		try {
			lis = ids.viewBestDrivers();
		} catch (Exception e) {
			throw new DriverNotFoundException("Best Drivers List is Empty");
		}
		return lis;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public List<Driver> insertDriver(@RequestBody Driver driver) {
		return ids.insertDriver(driver);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings("unused")
	@PutMapping
	public Driver updateDriver(@RequestBody Driver driver) throws DriverNotFoundException {
		Driver driverCheck = null;
		Driver d = null;
		try {
			driverCheck = viewDriver(driver.getDriverId());
			d = ids.updateDriver(driver);
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Id: " + driver.getDriverId() + " Not Found to Update!");
		}
		return d;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{driverId}")
	public List<Driver> deleteDriver(@PathVariable int driverId) throws DriverNotFoundException {
		List<Driver> d = null;
		try {
			d = ids.deleteDriver(driverId);
		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Id: " + driverId + " Not FOund To Delete!");
		}
		return d;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/carType/{type}")
	public List<Driver> getDriverByCarType(@PathVariable String type) throws DriverNotFoundException {
		List<Driver> d = null;
		try {
			d = ids.getDriverByCarType(type);

		} catch (Exception e) {
			throw new DriverNotFoundException("Driver with Car type: " + type + " Not Found!");
		}
		return d;
	}

}
