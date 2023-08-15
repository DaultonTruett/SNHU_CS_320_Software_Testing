
import java.util.ArrayList;

public class AppointmentService extends Appointment{
	
	public AppointmentService(String apptID, String apptDate, String apptDescription) {
		super(apptID, apptDate, apptDescription);
	}
	
	// In-memory data structure
	public static ArrayList<Appointment> apptList = new ArrayList<Appointment>();
	
	// Used for deleting objects during iteration, bypasses ConcurrentModificationError
	public static ArrayList<Appointment> tmpList = new ArrayList<Appointment>();
	
	// Add new appointment
	public static void addAppt(Appointment newAppt) {
		for(Appointment appt : apptList) {
			if(newAppt.getID().equals(appt.getID())) {
				throw new IllegalArgumentException("Appointment already exists");
			}
		}
		apptList.add(newAppt);
	}
	
	// Delete an appointment
	public static void deleteAppt(String ID) {
		for(Appointment appt : apptList) {
			if(appt.getID().equals(ID)) {
				tmpList.add(appt);
			}
		}
		apptList.removeAll(tmpList);
	}
	
	// Update description
	public static void updateDescription(String ID, String newDescription) {
		for(Appointment appt : apptList) {
			if(appt.getID().equals(ID)) {
				appt.setDescription(newDescription);
			}
		}
	}
	
}; // Closing AppointmentService class
