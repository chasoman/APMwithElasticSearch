package com.example.travelpedia.paxbooking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PaxBookingAppController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/{paxId}")
	public PaxBooking getBookingByPaxId(@PathVariable(value="paxId") String paxId) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			// Do Nothing
		}
		
		PaxBooking paxBooking = null;
		
		if(paxId.equalsIgnoreCase("9393862d-43da-486c-a0b1-a08dc9fe5f6a")){
			paxBooking = new PaxBooking(paxId
								  , "0b7c1dec-92cf-4a8f-a5d5-a2e7ae9d30ec"
								  , "The Savoy, London"
								  , 20220115
								  , 20220120
								  , "B102");
		}
		ObjectMapper obj = new ObjectMapper();
		try {
			logger.debug("---P4---"+obj.writeValueAsString(paxBooking));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paxBooking;
	}

}
