package com.example.contactapp;

import static com.example.contactapp.Person.BIRTHDAY_FORMAT;

import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.example.contactapp.data.DataAccessService;
import com.example.contactapp.data.FileAccessService;

public class ConsoleApp {

	private final static Scanner sc = new Scanner(System.in);

	@RequiresApi(api = Build.VERSION_CODES.O)
	public static void main(String[] args) {
		AddressBook addressBook = new AddressBook();
		DataAccessService dataService = new FileAccessService();

		List<BaseContact> contacts = dataService.loadContacts();
		for (BaseContact contact : contacts) {
			addressBook.add(contact);
		}

		boolean run = true;
		while (run) {
			printMenu();
			String input = sc.nextLine();

			switch (input) {
				case "1":
					//addContact(addressBook);
					break;
				case "2":
					listContacts(addressBook);
					break;
				case "3":
					findContact(addressBook);
					break;
				case "4":
					editContact(addressBook);
					break;
				case "5":
					searchContacts(addressBook);
					break;
				case "x":
				case "X":
				case "6":
					System.out.println(
							"Saving contacts in the address book before exiting the program...");
					dataService.saveContacts(addressBook.getContactList());
					System.out.println("Contacts Saved. Bye!");
					run = false;
					break;
				default:
					System.out.println("Invalid input " + input
							+ ". Please choose from 1 - 6, or X");
			}
		}
	}

	private static void printMenu() {
		System.out.println("Please select an action from the following: ");
		System.out.println("1. Add a new contact");
		System.out.println("2. Show all contacts");
		System.out.println("3. Find a contact with ID");
		System.out.println("4. Edit a contact");
		System.out.println("5. Search contacts");
		System.out.println("6. Exit");
		System.out.print("\nPlease choose an action (6 or X to quit): ");
	}

	@RequiresApi(api = Build.VERSION_CODES.O)
	private static void addContact(AddressBook addressbook) {
		System.out.println("============================================");
		System.out.println("Creating a contact in the address book.");

		BaseContact newContact = null;

//		long number = addressbook.nextNumber();
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter phone number (e.g. 123-456-7890): ");
		String phone = sc.nextLine();
		System.out.print("Enter location id: ");
		String locationId = sc.nextLine();
		System.out.print("Enter street address: ");
		String address = sc.nextLine();
		System.out.print("Enter city: ");
		String city = sc.nextLine();
		System.out.print("Enter state: ");
		String state = sc.nextLine();
		Location location = new Location(locationId, address, city, state);

		System.out.print("Enter photo id: ");
		String photoId = sc.nextLine();
		System.out.print("Enter file name for the photo: ");
		String photoFileName = sc.nextLine();
		System.out.print("Enter description for the photo: ");
		String photoInfo = sc.nextLine();
		Photo photo =
				new Photo(photoId, photoFileName, Instant.now(), photoInfo);
		List<Photo> photos = new ArrayList<>();
		photos.add(photo);

		System.out.print("Is this personal(P), or business(B)? ");
		String contactType = sc.nextLine();
		if (contactType.equals("P")) {
			System.out.print("Enter the birthday (in yyyyMMdd): ");
			Date birthday = null;
			String birthdayString = sc.nextLine();
			try {
				birthday = BIRTHDAY_FORMAT.parse(birthdayString);
			} catch (ParseException e) {
				System.out.printf(
						"Wrong birthday format %s. It will be ignored.\n",
						birthdayString);
			}
			System.out.print("Enter a description of the person: ");
			String info = sc.nextLine();

			newContact = new Person(name, phone, location, birthday, info);
		} else {
			System.out.println(
					"When time does the business open? (i.e. 0900, 1830)");
			int hourStart = sc.nextInt();
			System.out.println(
					"When time does the business close? (i.e. 0900, 1830)");
			int hourEnd = sc.nextInt();
			System.out.println("What is the url for the website?");
			String website = sc.nextLine();

			newContact = new Business(name, phone, location, hourStart, hourEnd, website);

		}

		addressbook.add(newContact);

		System.out.println("New contact added: ");
		System.out.println(newContact);

		System.out.println("============================================");
	}

	private static void listContacts(AddressBook addressBook) {
		System.out.println("============================================");
		System.out.println("Displaying all contacts in the address book.");
		for (BaseContact contact : addressBook.getContactList()) {
			System.out.println(contact);
		}
		System.out.println("============================================");
	}

	private static void findContact(AddressBook addressBook) {
		System.out.println("============================================");
		System.out.print("Please enter an ID of contact to display: ");
		long id = sc.nextLong();
		addressBook.display(id);
		System.out.println("============================================");
	}

	private static void editContact(AddressBook addressBook) {
		System.out.println("============================================");
		System.out.print("Please enter an ID of contact to edit: ");
		long id = sc.nextLong();
		addressBook.display(id);

		// TODO: show another option to choose what property to edit (i.e.
		// photos, location, birthday, etc).
		System.out.println("============================================");
	}

	private static void searchContacts(AddressBook addressBook) {
		System.out.println("============================================");
		System.out.print(
				"Please enter a query to search for all matching contacts: ");
		String query = sc.nextLine();
		System.out.println(addressBook.search(query));
		System.out.println("============================================");
	}
}