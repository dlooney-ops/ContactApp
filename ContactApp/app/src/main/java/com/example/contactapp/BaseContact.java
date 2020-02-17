package com.example.contactapp;


// Abstract class is similar concept to interface(s).
// It defines commonalities amongst classes.
public abstract class BaseContact {

	protected String name;
	protected String phone;
	protected Location location;
	//private List<Photo> photos;

	@Override
	public String toString() {
		return "number=" + ", name=" + name + ", phone=" + phone
				+ ", location=" + location;
	}

	public BaseContact(String name, String phone,
					   Location location) {

		this.name = name;
		this.phone = phone;
		this.location = location;

	}

//	@Override
//	public int compareTo(Person o) {
//		return this.name.compareTo(o.name);
//	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	public String getPhone() {
		return phone;
	}

//	public void setPhone(String phone) {
//		this.phone = phone;
//	}

	public Location getLocation() {
		return location;
	}

//	public void setLocation(Location location) {
//		this.location = location;
//	}



	// Returns `true` if String representation of any property
	// matches "input."

	public boolean contains(String input) {
		return name.contains(input) || phone.contains(input)
				|| location.contains(input);
	}

}