
package com.example.springcode.walmartcode.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.springcode.walmartcode.entity.ErrorMessage;



@ControllerAdvice
public class CustomExceptionHandler {
	
	
	@ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(DataNotFoundException ex){
        ErrorMessage errorResponse = new ErrorMessage(ex.getMessage(),
        		ex.getCause() != null ? ex.getCause().getMessage(): null, new Date());
        //errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        //errorResponse.setMessage(ex.getMessage());
        //errorResponse.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<ErrorMessage>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}