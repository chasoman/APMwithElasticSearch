package com.example.travelpedia.paxsearch;

public class PaxInformation {
	
	private final String paxId;
	private final String firstName;
	private final String lastName;
	private final String gender;
	private final long dateOfBirth;
	private final String addressLine1;
	private final String addressLine2;
	private final String city;
	private final String countryCode;
	private final String postalCode;
	private final String bookingId;
	private final String hotelName;
	private final long checkInDate;
	private final long checkOutDate;
	private final String roomNumber;
	
	public PaxInformation(String paxId
							,String firstName
							,String lastName
							,String gender
							,long dateOfBirth
							,String addressLine1
							,String addressLine2
							,String city
							,String countryCode
							,String postalCode
							,String bookingId
							,String hotelName
							,long checkInDate
							,long checkOutDate
							,String roomNumber) {
		
		this.paxId = paxId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.countryCode = countryCode;
		this.postalCode = postalCode;
		this.bookingId = bookingId;
		this.hotelName = hotelName;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomNumber = roomNumber;
		
	}

	public String getPaxId() {
		return paxId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public long getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getPostalCode() {
		return postalCode;
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
