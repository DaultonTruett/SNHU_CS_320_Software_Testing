
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;


class AppointmentTest{

	@Test
	public void testApptClass() {
		Appointment appt = new Appointment("1st ID", "2023-12-30", "1st description test");
		assertTrue(appt.getID().equals("1st ID"));
		assertTrue(appt.getDate().equals("2023-12-30"));
		assertTrue(appt.getDescription().equals("1st description test"));
	}
	
	@Test
	public void testApptIDNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, "2023-12-30", "2nd description test");
		});
	}
	
	@Test
	public void testApptIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("An ID that is too long", "2023-12-30", "2nd description test");
		});
	}
	
	@Test
	public void testApptDateNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("4th ID", null, "4th description test");
		});
	}
	
	@Test
	public void testApptDateNotInPast(){
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("5th ID", "1993-12-30", "5th description test");
		});
	}
	
	@Test 
	public void testDescriptionNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("6th ID", "2023-12-30", null);
		});
	}
	
	@Test
	public void testDescriptionNotTooLoing() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("7th ID", "2023-12-30", "7th description test that ends up being longer than 50 characters "
					+ "and therefor throws an exception that the description is too long.");
		});
	}	
	
}; // Closing AppointmentTest class
