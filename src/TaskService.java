
import java.util.ArrayList;

public class TaskService extends Task{
	
	// Constructor
	public TaskService(String taskID, String name, String description){
		super(taskID, name, description);
	}
 
	// In-memory data structure to store tasks
	public static ArrayList<Task> taskList = new ArrayList<Task>();
	
	// Used to store tasks to be deleted, bypasses ConcurrentModification error
	public static ArrayList<Task> tmpList = new ArrayList<Task>();
 
	// Method to add tasks to the taskList
	public static void addTask(Task newTask) {
		for(Task task : taskList) {
			if(newTask.getID().equals(task.getID())) {
				throw new IllegalArgumentException("Task ID already exists.");	
			}
		}
		taskList.add(newTask);
	}

	// Method to delete task form task list
	public static void deleteTask(String ID) {
		for(Task task : taskList) {
			if(task.getID().equals(ID)) {
				
				// Bypasses ConcurrentModification error
				tmpList.add(task);
			}
		}
		// Bypasses ConcurrentModification error
		taskList.removeAll(tmpList);
	}
	
	// Method to update name
	public static void updateName(String ID, String newName) {
		for(Task task : taskList) {
			if(task.getID().equals(ID)) {
				task.setName(newName);
			}
		}
	}
	
	// Method to update description
	public static void updateDescription(String ID, String newDescription) {
		for(Task task : taskList) {
			if(task.getID().equals(ID)) {
				task.setDescription(newDescription);
			}
		}
	}
	
}; // Closing TaskService class
