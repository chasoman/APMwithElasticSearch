package com.example.travelpedia.paxbooking;

public class PaxBooking {

	private final String paxId;
	private final String bookingId;
	private final String hotelName;
	private final long checkInDate;
	private final long checkOutDate;
	private final String roomNumber;
	
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

	public String getBookingId() {
		return bookingId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public long getCheckInDate() {
		return checkInDate;
	}

	public long getCheckOutDate() {
		return checkOutDate;
	}

	public String getRoomNumber() {
		return roomNumber;
	}
	
}
