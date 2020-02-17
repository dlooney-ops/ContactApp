package com.example.contactapp;

import android.content.Intent;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressBook {

	List<BaseContact> contactList;

	public AddressBook(List<BaseContact> contactList) {
		this.contactList = contactList;
	}

	public AddressBook() {

		this.contactList = new ArrayList<>();

		}


	public List<BaseContact> getContactList() {
		return contactList;
	}

	public void setContactList(List<BaseContact> contactList) {
		this.contactList = contactList;
	}

	public void add(BaseContact c) {
		contactList.add(c);
	}

	public void remove(BaseContact c) {
		contactList.remove(c);
	}

	public void display(long idNumber) {
		if (contactList.isEmpty()) {
			return; // Preemptively exits from the method.
		}

		for (BaseContact c : contactList) {
//			if (c.getNumber() == idNumber) {
//				// Print the contact with matching ID Number.
//				System.out.println(c);
//			}
		}
	}

	public long nextNumber() {
		long maxId = 0;
//		for (Person c : contactList) {
//			if (c.getNumber() > maxId) {
//				maxId = c.getNumber();
//			}
//		}

		return ++maxId;
	}

	public List<BaseContact> search(String input) {
		List<BaseContact> result = new ArrayList<>();

		// Search through contact and add to the "results" on match.
		for (BaseContact c : contactList) {
			if (c.contains(input)) {
				result.add(c);
			}
		}

		return result;
	}


}