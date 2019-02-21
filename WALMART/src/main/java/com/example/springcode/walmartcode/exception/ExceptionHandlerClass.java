package com.example.springcode.walmartcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler{
	
	//@ResponseStatus()

	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> DataNotFoundException(DataNotFoundException ex) {
				
		// ErroMessage er= new ErroMessage(new Date(), e.getLocalizedMessage());
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}