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

import com.am.cabbooking.entities.TripBooking;
import com.am.cabbooking.service.ITripBookingService;

@RestController
@RequestMapping("/tripbooking")
public class TripBookingController {

	@Autowired
	ITripBookingService itbs;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public TripBooking insertTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.insertTripBooking(tripBooking);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping
	public TripBooking updateTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.updateTripBooking(tripBooking);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping
	public List<TripBooking> deleteTripBooking(@RequestBody TripBooking tripBooking) {
		return itbs.deleteTripBooking(tripBooking);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{customerId}")
	public List<TripBooking> viewAllTripsCustomer(@PathVariable int customerId) {
		return itbs.viewAllTripsCustomer(customerId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/calculate/{customerId}")
	public float calculateBill(@PathVariable int customerId) {
		return itbs.calculateBill(customerId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/tripbookingId")
	public List<TripBooking> viewAllTripsById(@PathVariable int tripBookingId) {
		return itbs.viewAllTripsById(tripBookingId);
	}
}
