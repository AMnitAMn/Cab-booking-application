 package com.am.cabbooking.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.am.cabbooking.exception.InvalidUserOrPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.am.cabbooking.entities.Admin;
import com.am.cabbooking.entities.Customer;
import com.am.cabbooking.entities.TripBooking;
import com.am.cabbooking.exception.AdminNotFoundException;
import com.am.cabbooking.exception.CustomerNotFoundException;
import com.am.cabbooking.service.IAdminService;
import com.am.cabbooking.service.ICustomerService;
import com.am.cabbooking.util.LoginService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	IAdminService ias;

	@Autowired
	LoginService ls;

	@Autowired
	ICustomerService cusService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public Admin validateAdmin(@RequestBody Admin admin) throws InvalidUserOrPasswordException {
		Admin response = null;
		try {
			response = (Admin) ls.validateCredintials(admin);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Username/Password");
		}
		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<Admin> viewALlAdmin() {
		return ias.viewALlAdmin();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public Admin insertAdmin(@RequestBody Admin admin) {
		return ias.insertAdmin(admin);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{adminId}")
	public List<Admin> deleteAdmin(@PathVariable int adminId) throws AdminNotFoundException {
		List<Admin> s = null;
		try {
			s = ias.deleteAdmin(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with given ID: " + adminId + " Not Found to Delete");
		}
		return s;

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping
	public Admin updateAdmin(@RequestBody Admin admin) throws AdminNotFoundException {
		Admin a = null;

		try {
			a = ias.getAdminById(admin.getAdminId());
			ias.updateAdmin(admin);
		} catch (Exception e) {
			throw new AdminNotFoundException("Admin Not Found to Update");
		}
		return a;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{adminId}")
	public Admin GetAdminById(@PathVariable int adminId) throws AdminNotFoundException {
		Admin a = null;

		try {
			a = ias.getAdminById(adminId);

		} catch (Exception e) {
			throw new AdminNotFoundException("Admin with ID: " + adminId + " not found!");
		}
		return a;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings("unused")
	@GetMapping("/alltrips/{customerId}")
	public List<TripBooking> getAllTrips(@PathVariable int customerId) throws CustomerNotFoundException {

		Customer c = null;
		List<TripBooking> t = null;
		try {
			c = cusService.viewCustomer(customerId);
			t = ias.getAllTrips(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Can not find trips of Customer ID: " + customerId);
		}
		return t;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/cabwise")
	public List<TripBooking> getTripsCabwise() {
		return ias.getTripsCabwise();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/customerwise")
	public List<TripBooking> getTripsCustomerwise() {
		return ias.getTripsCustomerwise();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/datewise")
	public List<TripBooking> getTripsDatewise() {
		return ias.getTripsDatewise();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("fordays/{customerId}/{fromDate}/{toDate}")
	public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId,
			@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromDate,
			@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toDate)
			throws CustomerNotFoundException {
		return ias.getAllTripsForDays(customerId, fromDate, toDate);
	}

}