
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;

class AppointmentServiceTest {
	
	@Test
	public void testAddAppointment() {
		Appointment newAppt = new Appointment("1", "2023-11-20", "Lorem Ipsum");
		AppointmentService.addAppt(newAppt);
		
		for(Appointment appt : AppointmentService.apptList) {
			if(appt.getID().equals("1")) {
				assertTrue(appt.getID().equals("1"));
			}
		}
	}
	
	@Test
	public void testAddDuplicateAppointment() {
		Appointment newAppt = new Appointment("2", "2023-11-20", "Lorem Ipsum");
		AppointmentService.addAppt(newAppt);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {	
			Appointment duplicateAppt = new Appointment("2", "2023-11-20", "Lorem Ipsum");
			AppointmentService.addAppt(duplicateAppt);
		});
	}
	
	@Test
	public void testDateNotInPast() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {	
			new Appointment("3", "1993-11-20", "Lorem Ipsum");
		});
	}
	
	@Test
	public void testDeleteAppt() {
		Appointment newAppt = new Appointment("4", "2023-11-20", "Lorem Ipsum");
		AppointmentService.apptList.add(newAppt);
		
		int sizeBeforeDelete = AppointmentService.apptList.size();
		
		AppointmentService.deleteAppt(newAppt.getID());
		
		int sizeAfterDelete = AppointmentService.apptList.size();
		
		assertTrue(sizeBeforeDelete > sizeAfterDelete);
	}
	
	@Test
	public void testUpdateDescription() {
		Appointment newAppt = new Appointment("5", "2023-11-20", "Lorem Ipsum");
		AppointmentService.apptList.add(newAppt);
		
		for(Appointment appt : AppointmentService.apptList) {
			if(newAppt.getID().equals(appt.getID())) {
				AppointmentService.updateDescription(newAppt.getID(), "New updated description");
				assertTrue(appt.getDescription().equals("New updated description"));
			}
		}
	}


}; // Closing AppointmentServiceTest class
