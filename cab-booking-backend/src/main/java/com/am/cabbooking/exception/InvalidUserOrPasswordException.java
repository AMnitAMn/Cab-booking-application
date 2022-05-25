package com.am.cabbooking.exception;

public class InvalidUserOrPasswordException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidUserOrPasswordException() {

	}

	public InvalidUserOrPasswordException(String message) {
		super(message);
	}

}
