package com.am.cabbooking.exception;

public class CabNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CabNotFoundException() {
		
	}
	
	public CabNotFoundException(String message) {
		super(message);
	}

}
