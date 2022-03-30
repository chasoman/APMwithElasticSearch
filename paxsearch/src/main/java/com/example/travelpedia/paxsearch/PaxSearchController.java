package com.example.travelpedia.paxsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PaxSearchController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${PAX_DETAILS_HOST_PORT}")
	private String PAX_DETAILS_HOST_PORT;
	
	@Value("${PAX_BOOKING_HOST_PORT}")
	private String PAX_BOOKING_HOST_PORT;
	
	@GetMapping("/info")
	public PaxInformation getPaxInfoByPaxName(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		PaxInformation info = null;
		
		if(firstName.equalsIgnoreCase("John") 
				&& lastName.equalsIgnoreCase("Doe")) {
			RestTemplate restTemplate = new RestTemplate();
			PaxDetails paxDetails = restTemplate.getForObject("http://"+PAX_DETAILS_HOST_PORT+"/pax-details/9393862d-43da-486c-a0b1-a08dc9fe5f6a", PaxDetails.class);
			PaxBooking paxBooking = restTemplate.getForObject("http://"+PAX_BOOKING_HOST_PORT+"/pax-booking/9393862d-43da-486c-a0b1-a08dc9fe5f6a", PaxBooking.class);
			
			if(paxDetails != null) {
				if(paxBooking != null) {
					info = new PaxInformation(paxDetails.getPaxId()
											  , paxDetails.getFirstName()
											  , paxDetails.getLastName()
											  , paxDetails.getGender()
											  , paxDetails.getDateOfBirth()
											  , paxDetails.getAddressLine1()
											  , paxDetails.getAddressLine2()
											  , paxDetails.getCity()
											  , paxDetails.getCountryCode()
											  , paxDetails.getPostalCode()
											  , paxBooking.getBookingId()
											  , paxBooking.getHotelName()
											  , paxBooking.getCheckInDate()
											  , paxBooking.getCheckOutDate()
											  , paxBooking.getRoomNumber());
				}else {
					info = new PaxInformation(paxDetails.getPaxId()
							  , paxDetails.getFirstName()
							  , paxDetails.getLastName()
							  , paxDetails.getGender()
							  , paxDetails.getDateOfBirth()
							  , paxDetails.getAddressLine1()
							  , paxDetails.getAddressLine2()
							  , paxDetails.getCity()
							  , paxDetails.getCountryCode()
							  , paxDetails.getPostalCode()
							  , ""
							  , ""
							  , 0
							  , 0
							  , "");
					
				}
			}
		}else {
			throw new PaxSearchException("Passenger not found => "+firstName+" "+lastName);
		}
		
		ObjectMapper obj = new ObjectMapper();
		try {
			logger.debug("---P4---"+obj.writeValueAsString(info));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return info;
	}
}
