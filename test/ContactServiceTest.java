
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;

class ContactServiceTest{

	@Test
	void testAddContact() {
		Contact newContact = new Contact("test1", "firstName", "lastName", "9992221010", "address");
		ContactService.addContact(newContact);
		
		for(Contact contact : ContactService.contactList) {
			if(contact.getContactID().equals("test1")){
				assertTrue(contact.getContactID().equals("test1"));
			}
		}
	}
	
	@Test
	void testAddDuplicateContact() {
		Contact newContact = new Contact("2nd testID", "Bob", "Jones", "9992221010", "2345 Address St");
		ContactService.addContact(newContact);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {	
			Contact duplicateContact = new Contact("2nd testID", "Bob", "Jones", "9992221010", "2345 Address St");
			ContactService.addContact(duplicateContact);
		});
	}
		
	
	@Test
	void testUpdateFirstName() {
		Contact newContact = new Contact("test2", "firstName", "lastName", "9992221010", "address");
		ContactService.addContact(newContact);
		
		ContactService.updateFirstName("test2", "Tim");
		for(Contact contact : ContactService.contactList) {
			if(contact.getContactID().equals("test2")){
				assertTrue(contact.getFirstName().equals("Tim"));
			}
		}
	}
	
	@Test
	void testUpdateLastName() {
		Contact newContact = new Contact("test3", "firstName", "lastName", "9992221010", "address");
		ContactService.addContact(newContact);
		
		ContactService.updateLastName("test3", "Johnson");
		for(Contact contact: ContactService.contactList) {
			if(contact.getContactID().equals("test3")){
				assertTrue(contact.getLastName().equals("Johnson"));
			}
		}
	}
	
	@Test
	void testUpdatePhone() {
		Contact newContact = new Contact("test4", "firstName", "lastName", "9992221010", "address");
		ContactService.addContact(newContact);
		
		ContactService.updatePhone("test4", "2222222222");
		for(Contact contact : ContactService.contactList) {
			if(contact.getContactID().equals("test4")){
				assertTrue(contact.getPhoneNumber().equals("2222222222"));
			}
		}
	}
	
	@Test
	void testUpdateAddress() {
		Contact newContact = new Contact("test5", "firstName", "lastName", "9992221010", "address");
		ContactService.addContact(newContact);
		
		ContactService.updateAddress("test5", "8765 new address");
		for(Contact contact : ContactService.contactList) {
			if(contact.getContactID().equals("test5")){
				assertTrue(contact.getAddress().equals("8765 new address"));
			}
		}
	}

	@Test
	void testDeleteContact() {
		Contact newContact = new Contact("test6", "firstName", "lastName", "9992221010", "address");
		ContactService.addContact(newContact);
		
		int sizeBefore = ContactService.contactList.size();
		ContactService.deleteContact("test6");
		int sizeAfter = ContactService.contactList.size();
		assertTrue(sizeBefore > sizeAfter);
	}
	
	
} // Closing ContactServiceTest Class
