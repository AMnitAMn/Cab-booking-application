package com.am.cabbooking.controller;

import com.am.cabbooking.exception.InvalidUserOrPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.am.cabbooking.entities.Admin;
import com.am.cabbooking.entities.Customer;
import com.am.cabbooking.entities.Driver;
import com.am.cabbooking.util.LoginServiceImpl;

@RestController
@RequestMapping("/login/")
public class LoginController {
	@Autowired
	LoginServiceImpl lServiceImpl;

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/customer/{username}/{password}")
	public Customer customerLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {
		try {
			Customer customer = new Customer();
			customer.setUsername(username);
			customer.setPassword(password);

			return (Customer) lServiceImpl.validateCredintials(customer);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/admin/{username}/{password}")
	public Admin adminLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {

		try {
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			return (Admin) lServiceImpl.validateCredintials(admin);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/driver/{username}/{password}")
	public Driver driverLogin(@PathVariable("username") String username, @PathVariable("password") String password)
			throws InvalidUserOrPasswordException {

		try {
			Driver driver = new Driver();
			driver.setUsername(username);
			driver.setPassword(password);
			return (Driver) lServiceImpl.validateCredintials(driver);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Login/Password");
		}

	}
}
