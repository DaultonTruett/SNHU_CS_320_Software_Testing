import java.util.ArrayList;

public class ContactService extends Contact{

	// Constructor
	public ContactService(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		super(contactID, firstName, lastName, phoneNumber, address);
	};
 
	// ArrayList to hold contacts as they are created
	public static ArrayList<Contact> contactList = new ArrayList<Contact>();
	// Temp list to hold contact object to delete, bypasses ConcurrentModificationError
	public static ArrayList<Contact> tmpList = new ArrayList<Contact>();
	
	// Initialize ArrayList for testing
	//public static void initializeContactList() {
		//Contact initialContact = new Contact("username", "Stan", "Jennings", "5550002233", "12345 Testing address");
		//contactList.add(initialContact);
	//}
	
	// Method to add a contact into the ArrayList
	public static void addContact(Contact newContact) {
		for(Contact contact : contactList) {
			if(newContact.getContactID().equals(contact.getContactID())) {
				throw new IllegalArgumentException("Contact already exists with that ID.");
			}
		}
		contactList.add(newContact);
	};
	
	// Method to update first name
	public static void updateFirstName(String ID, String firstNameUpdate) {
		for(Contact contact : contactList) {
			if(contact.getContactID().equals(ID)) {
				contact.setFirstName(firstNameUpdate);
			}
		}
	}
	
	// Method to update last name
	public static void updateLastName(String ID, String lastNameUpdate) {
		for(Contact contact : contactList) {
			if(contact.getContactID().equals(ID)) {
				contact.setLastName(lastNameUpdate);
			}
		}
	}
	
	// Method to update phone number
	public static void updatePhone(String ID, String phoneUpdate) {
		for(Contact contact : contactList) {
			if(contact.getContactID().equals(ID)) {
				contact.setPhoneNumber(phoneUpdate);
			}
		}
	}
	
	// Method to update address
	public static void updateAddress(String ID, String addressUpdate) {
		for(Contact contact : contactList) {
			if(contact.getContactID().equals(ID)) {
				contact.setAddress(addressUpdate);
			}
		}
	}
	
	// Method to delete contact
	public static void deleteContact(String ID) {
		for(Contact contact : contactList) {
			if(contact.getContactID().equals(ID)) {
				tmpList.add(contact);
			}
		}
		contactList.removeAll(tmpList);
	}
	
}