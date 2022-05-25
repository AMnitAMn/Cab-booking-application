package com.am.cabbooking.exception;

public class DriverNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DriverNotFoundException() {

	}
	
	public DriverNotFoundException(String message) {
		super(message);
	}

}
