package com.am.cabbooking.exception;

public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomerNotFoundException() {
		
	}
	
	public CustomerNotFoundException(String message) {
		super(message);
	}
	
}
