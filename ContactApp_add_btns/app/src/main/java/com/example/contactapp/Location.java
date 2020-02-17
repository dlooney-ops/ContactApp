package com.example.contactapp;

public class Location {

	private String idNumber;
	private String address;
	private String city;
	private String state;

	public Location(String idNumber, String address, String city,
					String state) {
		super();
		this.idNumber = idNumber;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public boolean contains(String input) {
		return idNumber.contains(input) || address.contains(input)
				|| city.contains(input) || state.contains(input);
	}

	@Override
	public String toString() {
		return "Location [idNumber=" + idNumber + ", address=" + address
				+ ", city=" + city + ", state=" + state + "]";
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

}