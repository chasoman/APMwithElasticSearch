package com.example.travelpedia.paxsearch;

public class PaxSearchExceptionResponse {
	
	private final String errorCode;
	private final String errorMessage;
	
	public PaxSearchExceptionResponse(String errorCode
										,String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	

}
