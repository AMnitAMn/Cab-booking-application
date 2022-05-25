package com.am.cabbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.am.cabbooking.entities.Cab;
import com.am.cabbooking.exception.CabNotFoundException;
import com.am.cabbooking.service.ICabService;

@RestController
@RequestMapping("/cab")
public class CabController {

	@Autowired
	ICabService iCabService;

	public Cab insertCab(@RequestBody Cab cab) {
		return iCabService.insertCab(cab);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping
	public Cab updateCab(@RequestBody Cab cab) throws CabNotFoundException {
		@SuppressWarnings("unused")
		Cab cabCheck = null;
		Cab c = null;
		try {
			cabCheck = iCabService.getCabById(cab.getCabId());
			c = iCabService.updateCab(cab);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab not found to Update");
		}
		return c;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping
	public Cab deleteCab(Cab cab) throws CabNotFoundException {
		@SuppressWarnings("unused")
		Cab cabCheck = null;
		Cab c = null;
		try {
			cabCheck = iCabService.getCabById(cab.getCabId());
			c = iCabService.deleteCab(cab);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab not found to Delete");
		}
		return c;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value = "/{cabId}")
	public List<Cab> deleteCabById(@PathVariable int cabId) throws CabNotFoundException {
		try {
			return iCabService.deleteCabById(cabId);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab not found to Delete");
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/type/{carType}")
	public List<Cab> viewCabsOfType(@PathVariable String carType) {
		return iCabService.viewCabsOfType(carType);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/count/{carType}")
	public int countCabsOfType(@PathVariable String carType) {
		return iCabService.countCabsOfType(carType);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/{cabId}")
	public Cab getCabById(@PathVariable int cabId) throws CabNotFoundException {
		try {
			return iCabService.getCabById(cabId);
		} catch (Exception e) {
			throw new CabNotFoundException("Cab With ID: " + cabId + " Not Found");
		}

	}

}