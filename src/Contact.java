
import java.lang.String;

public class Contact {
	
	// Attributes
	private String contactID; 	// length <= 10, Cannot be updated, cannot be NULL
	private String firstName; 	// length <= 10, update with ContactService, cannot be NULL
	private String lastName;	// length <= 10, update with ContactService, cannot be NULL
	private String phoneNumber;	// length == 10, update with ContactService, cannot be NULL
	private String address;		// length <= 30, update with ContactService, cannot be NULL
	
	// Constructor
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address){
		
		if(contactID == null)  {
			throw new IllegalArgumentException("Contact ID cannot be null");
			
		}else if(contactID.length() >= 11) {
			throw new IllegalArgumentException("Contact ID cannot be greater than 10 characters in");
			
		}else {
			this.contactID = contactID;
		}
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setAddress(address);
	}
	
	// Getter methods 
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	
	// Setter methods, will not assign if input is > requirement or null
	public void setFirstName(String userFirstName) {
		if(userFirstName == null) {
			throw new IllegalArgumentException("First name cannot be null");
			
		}else if (userFirstName.length() >= 11) {
			throw new IllegalArgumentException("First name can cannot be greater than 10 characters long");
			
		}else {
			this.firstName = userFirstName;
		}
	}
	
	public void setLastName(String userLastName) {
		if(userLastName == null) {
			throw new IllegalArgumentException("Last name cannot be null");
			
		}else if (userLastName.length() >= 11) {
			throw new IllegalArgumentException("Last name cannot be greater than 10 characters long");
			
		}else {
			this.lastName = userLastName;
		}
	}
	
	public void setPhoneNumber(String userPhoneNumber) {
		if(userPhoneNumber == null) {			
			throw new IllegalArgumentException("Phone number cannot be null");
			
		}else if (userPhoneNumber.length() != 10) {
			throw new IllegalArgumentException("Phone number must be 10 digits in length.");
			
		}else {
			this.phoneNumber = userPhoneNumber;
		}
	}
	
	public void setAddress(String userAddress) {
		if(userAddress == null) {
			throw new IllegalArgumentException("Address cannot be null");
			
		}else if (userAddress.length() >= 31) {
			throw new IllegalArgumentException("Address cannot be greater than 30 characters long");
			
		}else {
			this.address = userAddress;
		}
	}
	
}; // Closing class brace                              
