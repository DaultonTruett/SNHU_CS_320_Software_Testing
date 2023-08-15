
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Assertions;

class TaskServiceTest{
	
	@Test
	void testAddTask() {
		Task newTask = new Task("1st testID", "1st test name", "1st test description");
		TaskService.addTask(newTask);
		
		for(Task task : TaskService.taskList) {
			if(task.getID().equals("1st testID")) {
				assertTrue(task.getID().equals("1st testID"));
			}
		}
	}
 	
	@Test
	void testAddDuplicateTask() {
		Task task = new Task("2nd testID", "2nd test name", "2nd test description");
		TaskService.addTask(task);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {	
			Task duplicateTask = new Task("2nd testID", "2nd test name", "2nd test description");
			TaskService.addTask(duplicateTask);
		});
	}
	
	
	@Test
	void testDeleteTask() {
		Task deleteTask = new Task("3rd testID", "3rd test name", "3rd test description");
		TaskService.taskList.add(deleteTask);
		int sizeBeforeDelete = TaskService.taskList.size();
		
		TaskService.deleteTask(deleteTask.getID());
		
		int sizeAfterDelete = TaskService.taskList.size();
		assertTrue(sizeAfterDelete < sizeBeforeDelete);
	}
	
	@Test
	void testUpdateName() {
		Task updateTaskName = new Task("4th testID", "4th test name", "4th test description");
		TaskService.taskList.add(updateTaskName);
		
		for(Task task : TaskService.taskList) {
			if(task.getID().equals(updateTaskName.getID())) {
				TaskService.updateName(task.getID(), "Updated name");
				assertTrue(task.getName().equals("Updated name"));
			}
		}
	}
	
	@Test
	void testUpdateDescription() {
		Task updateTaskDescription = new Task("5th testID", "5th test name", "5th test description");
		TaskService.taskList.add(updateTaskDescription);
		
		for(Task task : TaskService.taskList) {
			if(task.getID().equals(updateTaskDescription.getID())) {
				TaskService.updateDescription(task.getID(), "Updated description");
				assertTrue(task.getDescription().equals("Updated description"));
			}
		}
	}
	
}; // Closing TaskServiceTest class
