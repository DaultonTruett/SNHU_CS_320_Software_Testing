

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;

class ContactTest{
	
	@Test
	void testContactClass() {
		Contact contact = new Contact("123456789", "John", "Smith", "9992221010", "123 test");
		
		assertTrue(contact.getContactID().equals("123456789"));
		assertTrue(contact.getFirstName().equals("John"));
		assertTrue(contact.getLastName().equals("Smith"));
		assertTrue(contact.getPhoneNumber().equals("9992221010"));
		assertTrue(contact.getAddress().equals("123 test"));
	}
	
	@Test
	void testContactClassIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891011", "First name", "last name", "9992221010", "address");
		});
	}
	
	@Test
	void testContactClassIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "First name", "last name", "9992221010", "address");
		});
	}
	
	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("2", "Firstnametoolong", "Last name", "9992221010", "address");
		});
	}
	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("3", null, "Last name", "9992221010", "address");
		});
	}
 
	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("4", "First name", "Lastnametoolong", "9992221010", "address");
		});
	}
	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("5", "First name", null, "9992221010", "address");
		});
	}
 
	@Test
	void testContactClassPhoneNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("6", "First name", "Last name", "12345678910", "address");
		});
	}
	
	@Test
	void testContactClassPhoneNumberTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("6", "First name", "Last name", "123", "address");
		});
	}
	
	@Test
	void testContactClassPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("7", "First name", "Last name", null, "address");
		});
	}
	
	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("8", "First name", "Last name", "9992221010", "123456 1st Avenue Boulder, Colorado 80020");
		});
	}
	@Test
	void testContactClassAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("77", "First name", "Last name", "9992221010", null);
		});
	}
	
}