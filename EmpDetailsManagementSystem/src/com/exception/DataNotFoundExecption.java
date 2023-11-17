package com.exception;

public class DataNotFoundExecption extends RuntimeException{
	String message;

	public DataNotFoundExecption(String message) {
		
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	

}
