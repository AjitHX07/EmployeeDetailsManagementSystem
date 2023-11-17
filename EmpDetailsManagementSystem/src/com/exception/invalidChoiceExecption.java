package com.exception;

public class invalidChoiceExecption extends RuntimeException {
	String message;
	
	public invalidChoiceExecption(String message) {
		this.message=message;
		
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	
	//employee not found
	//data not found
	

}
