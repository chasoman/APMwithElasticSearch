package com.example.travelpedia.paxsearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaxBooking {

	private String paxId;
	private String bookingId;
	private String hotelName;
	private long checkInDate;
	private long checkOutDate;
	private String roomNumber;
	
	public PaxBooking() {
		
	}
	
	public PaxBooking(String paxId
					  ,String bookingId
					  ,String hotelName
					  ,long checkInDate
					  ,long checkOutDate
					  ,String roomNumber) {
		this.paxId = paxId;
		this.bookingId = bookingId;
		this.hotelName = hotelName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomNumber = roomNumber;
	}

	public String getPaxId() {
		return paxId;
	}

	public void setPaxId(String paxId) {
		this.paxId = paxId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public long getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(long checkInDate) {
		this.checkInDate = checkInDate;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(long checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	
}
