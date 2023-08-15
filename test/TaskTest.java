
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;

class TaskTest{
	
	@Test
	void testTaskClass(){
		Task task = new Task("ID", "name", "Description");
		assertTrue(task.getID().equals("ID"));
		assertTrue(task.getName().equals("name"));
		assertTrue(task.getDescription().equals("Description"));
	}
	
	@Test 
	void testTaskClassIDNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "First test name", "First test description");
		});
	}
	
	@Test
	void testTaskClassIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("userIDTooLongTest", "Second test name", "Second test description");
		});
	}
	
	@Test void testTaskClassNameNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("3rd ID", null, "Third test description");
		});
	}
	
	@Test
	void testTaskClassNameNotTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("4th ID", "4th test name, but this one is going to be too long.", "Fourth test description");
		});
	}
	
	@Test
	void testTaskClassDescriptionNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("5th ID", "5th test name", null);
		});
	}
	
	@Test
	void testTaskClassDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("6th ID", "6th test name", "This test description should be long enough to throw an exception.");
		});
	}
	
}; // Closing TaskTest class 
