package com.example.travelpedia.paxsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class PaxSearchExceptionHandler {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<PaxSearchExceptionResponse> genericException(Exception ex){

		PaxSearchExceptionResponse response = new PaxSearchExceptionResponse("PAXSEARCH.ERR.500", "UNKNOWN Error");
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		if(ex instanceof PaxSearchException) {
			response = new PaxSearchExceptionResponse("PAXSEARCH.ERR.400", ex.getMessage());
			status = HttpStatus.BAD_REQUEST; 
		} else {
			response = new PaxSearchExceptionResponse("PAXSEARCH.ERR.500", ex.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		ObjectMapper obj = new ObjectMapper();
		try {
			logger.debug("---P4---"+obj.writeValueAsString(response));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<PaxSearchExceptionResponse>(response, status);
	}

}
