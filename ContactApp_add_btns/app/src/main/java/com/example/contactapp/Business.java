package com.example.contactapp;

import java.util.List;

public class Business extends BaseContact {

	private int hourStart;
	private int hourEnd;
	private String website;

	public boolean isOpen(int hour) {
		return hour >= hourStart && hour <= hourEnd;
	}

	public Business(String name, String phone, Location location, int hourStart, int hourEnd, String website) {
		super(name, phone, location);
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
		this.website = website;
	}

	@Override
	public String toString() {
		return "Business [ " + super.toString() + ", hourOfOperation=" + hourStart
				+ " - " + hourEnd+ ", website=" + website+ "]";
	}

	@Override
	public boolean contains(String input) {
		return super.contains(input) || website.contains(input);
	}

	public int getHourStart() {
		return hourStart;
	}

	public int getHourEnd() {
		return hourEnd;
	}

	public String getWebsite() {
		return website;
	}

}