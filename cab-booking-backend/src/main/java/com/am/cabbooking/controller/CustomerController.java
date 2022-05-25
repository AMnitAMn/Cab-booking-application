package com.am.cabbooking.controller;

import java.util.List;

import com.am.cabbooking.exception.InvalidUserOrPasswordException;
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

import com.am.cabbooking.entities.Customer;
import com.am.cabbooking.exception.CustomerNotFoundException;
import com.am.cabbooking.service.ICustomerService;
import com.am.cabbooking.util.LoginService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	ICustomerService cusService;

	@Autowired
	LoginService ls;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	public Customer validateCustomer(@RequestBody Customer customer) throws InvalidUserOrPasswordException {
		Customer response = null;
		try {
			response = (Customer) ls.validateCredintials(customer);
		} catch (Exception e) {
			throw new InvalidUserOrPasswordException("Invalid Username/Password");
		}
		return response;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public Customer insertCustomer(@RequestBody Customer customer) {
		return cusService.insertCustomer(customer);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings("unused")
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		Customer cViewer = null;
		Customer c = null;
		try {
			cViewer = viewCustomer(customer.getCustomerId());
			c = cusService.updateCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found to perform Update Operation!");
		}
		return c;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@SuppressWarnings("unused")
	@DeleteMapping
	public Customer deleteCustomer(Customer customer) throws CustomerNotFoundException {
		Customer cViewer = null;
		Customer c = null;
		try {
			cViewer = viewCustomer(customer.getCustomerId());
			c = cusService.deleteCustomer(customer);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found to perform Delete Operation!");
		}
		return c;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "all")
	public List<Customer> viewCustomers() {
		return cusService.viewCustomers();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
		Customer c = null;
		try {
			c = cusService.viewCustomer(customerId);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer with Id: " + customerId + " Not Found!");
		}
		return c;
	}

}
