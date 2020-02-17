package com.example.contactapp.data;

import java.util.List;

import com.example.contactapp.BaseContact;
import com.example.contactapp.Person;

public interface DataAccessService {

	List<BaseContact> loadContacts();

	void saveContacts(List<BaseContact>contacts);

}
