package com.example.contactapp.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import static com.example.contactapp.Person.BIRTHDAY_FORMAT;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.example.contactapp.BaseContact;
import com.example.contactapp.Location;
import com.example.contactapp.Person;
import com.example.contactapp.Photo;

public class FileAccessService implements DataAccessService {

	private static final String CONTACTS_FILE = "/home/dlooney/Documents/contacts_list.csv";

	public FileAccessService() {
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	@Override
	public List<BaseContact> loadContacts() {
		List<BaseContact> contacts = new ArrayList<>();
		Scanner inputFile;
		try {
			inputFile = new Scanner(new File(CONTACTS_FILE));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot open contacts file: " + CONTACTS_FILE);
			e.printStackTrace();
			return null;
		}

		while (inputFile.hasNextLine()) {
			contacts.add(parsePerson(inputFile.nextLine()));
		}
		inputFile.close();

		return contacts;
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	private static Person parsePerson(String line) {
		String[] fields = line.split(",");

		long number = Long.parseLong(fields[0]);
		String name = fields[1];
		String phone = fields[2];

		String locationId = fields[3];
		String address = fields[4];
		String city = fields[5];
		String state = fields[6];
		Location location = new Location(locationId, address, city, state);

		String photoId = fields[7];
		String photoFile = fields[8];
		String takenAtString = fields[9];
		String photoInfo = fields[10];
		Instant takenAt = Instant.parse(takenAtString);
		Photo photo = new Photo(photoId, photoFile, takenAt, photoInfo);
		List<Photo> photos = new ArrayList<>();
		photos.add(photo);

		String birthdayString = fields[11];

		Date birthday = null;
		try {
			birthday = Person.BIRTHDAY_FORMAT.parse(birthdayString);
		} catch (ParseException e) {
			System.out.printf(
					"Invalid birthday for %s: %s. Please provide birtday in yyyyMMdd format.\n",
					name, birthdayString);
		}
		String info = fields[12];

		return new Person(name, phone, location, birthday, info);
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	@Override
	public void saveContacts(List<BaseContact> contacts) {
		try (BufferedWriter bw =
					 new BufferedWriter(new FileWriter(CONTACTS_FILE))) {
			for (BaseContact contact : contacts) {
				bw.append(formatPerson(contact));
				bw.append("\n");
			}
		} catch (IOException e) {
			System.out
					.println("Cannot open/write to the file " + CONTACTS_FILE);
			e.printStackTrace();
		}

	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	private String formatPerson(BaseContact contact) {
		if (!(contact instanceof Person)) {
			System.out.println("Unsupported: cannot parse non-Person contact: "
					+ contact.getName());
			return "";
		}

		Person person = (Person) contact;

		List<String> fields = new ArrayList<>();

//		fields.add("" + person.getNumber());
		fields.add(person.getName());
		fields.add(person.getPhone());

		fields.add(person.getLocation().getIdNumber());
		fields.add(person.getLocation().getAddress());
		fields.add(person.getLocation().getCity());
		fields.add(person.getLocation().getState());

//		if (!person.getPhotos().isEmpty()) {
//			// Save only the first photo, if exists, for now.
//			Photo p = person.getPhotos().get(0);
//			fields.add(p.getIdNumber());
//			fields.add(p.getFileName());
//			fields.add(p.getTakenAt().toString());
//			fields.add(p.getInfo());
//		}

		fields.add(BIRTHDAY_FORMAT.format(person.getBirthday()));
		fields.add(person.getInfo());
		return String.join(",", fields);
	}

}