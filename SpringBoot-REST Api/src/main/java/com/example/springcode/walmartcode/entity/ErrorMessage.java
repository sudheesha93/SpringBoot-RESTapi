package com.example.springcode.walmartcode.entity;

import java.util.Date;

public class ErrorMessage {
	
	private String errorCode;
	private String message;
	private Date time;
	
	
	public ErrorMessage(String errorCode, String message, Date time) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.time = time;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	
	
	
	
	
	
}
