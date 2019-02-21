package com.example.springcode.walmartcode.exception;


public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message) {
		
		super(message);
	}
	
	public DataNotFoundException(String code, Throwable error) {
		
		super(code, error);
	}
	
}