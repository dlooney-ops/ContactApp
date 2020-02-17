package com.example.contactapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Person extends BaseContact {

	public static final DateFormat BIRTHDAY_FORMAT =
			new SimpleDateFormat("yyyyMMdd");

	private Date birthday;
	private String info;
//	private List<Person> relatives;


	public Person(String name, String phone, Location location, Date birthday, String info) {
		super(name, phone, location);
		this.birthday = birthday;
		this.info = info;
//		this.relatives = relatives;

	}

	@Override
	public boolean contains(String input) {
		return super.contains(input) || info.contains(input)
				|| birthday.toString().contains(input);
	}

	@Override
	public String toString() {
		return "Person [ " + super.toString() + ", birthday=" + birthday
				+ ", info=" + info + ", ]";
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getInfo() {
		return info;
	}

//	public List<Person> getRelatives() {
//		return relatives;
//	}

}