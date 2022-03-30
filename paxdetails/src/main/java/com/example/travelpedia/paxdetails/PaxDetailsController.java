package com.example.travelpedia.paxdetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PaxDetailsController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/{paxId}")
	public PaxDetails getPaxDetailsByPaxId(@PathVariable(value = "paxId") String paxId) {
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// Do Nothing
		}
		
		PaxDetails details = null;
		
		if(paxId.equalsIgnoreCase("9393862d-43da-486c-a0b1-a08dc9fe5f6a")) {
			details = new PaxDetails(paxId
									, "John"
									, "Doe"
									, "Male"
									, 19660101
									, "JWB Center"
									, "Langley"
									, "Virginia"
									, "US"
									, "30080");
		}
		
		ObjectMapper obj = new ObjectMapper();
		try {
			logger.debug("---P4---"+obj.writeValueAsString(details));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return details;
	}
}
