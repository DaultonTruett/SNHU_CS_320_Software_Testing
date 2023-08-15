
import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;


public class Appointment{
	
	// Attributes 
	private String apptID; // 10 characters or less, NOT null, immutable
	private String apptDate; // Cannot be in the past, NOT null
	private String apptDescription; // 50 characters or less, NOT null 
	
	// Constructor
	public Appointment(String apptID, String apptDate, String apptDescription) {
		
		
		if(apptID == null) {
			throw new IllegalArgumentException("Appt ID cannot be NULL.");
			
		}else if(apptID.length() >= 11) {
			throw new IllegalArgumentException("Appt ID cannot exceed 10 characters in length.");
			
		}else {
			this.apptID = apptID;
		}
		
		setDate(apptDate);
		setDescription(apptDescription);
	}

	// Setters
	public void setDate(String newDate) {
		
		if(newDate == null) {
			throw new IllegalArgumentException("Date cannont be NULL.");	
		}
	
		// Obtain the current date 
		// Default format is yyyy-MM-dd
		LocalDate currentDate = LocalDate.now();
		
		// Parse newDate into a LocalDate object for isBefore() comparison
		LocalDate userDate = LocalDate.parse(newDate);
		
		if(userDate.isBefore(currentDate)) {
			throw new IllegalArgumentException("Date cannot be in the past.");
				
		}else {
			this.apptDate = newDate;
		}
	}
		
	public void setDescription(String newDescription) {
		if(newDescription == null) {
			throw new IllegalArgumentException("Description cannont be NULL.");
			
		}else if(newDescription.length() >= 51) {
			throw new IllegalArgumentException("Description cannont exceed 50 characters in length.");
			
		}else {
			this.apptDescription = newDescription;
		}
	}

	// Getters
	public String getID() {
		return this.apptID;
	}
	
	public String getDate() {
		return this.apptDate;
	}
	
	public String getDescription() {
		return this.apptDescription;
	}
	
}; // Closing Appointment class
