
public class Task{
	
	// Attributes
	private String taskID; // 10 characters or less, NOT null, immutable
	private String name; // 20 characters or less, NOT null, mutable
	private String description; // 50 characters or less, NOT null, mutable
	
	// Constructor
	public Task(String taskID, String name, String description) {
		
		// Assignment of the ID within the constructor grants the ID immutability
		if(taskID == null) {
			throw new IllegalArgumentException("Task ID cannot be null.");
				
		}else if(taskID.length() >= 11) {
			throw new IllegalArgumentException("Task ID cannot be greater than 10 characters long.");
	
		}else {
			this.taskID = taskID;
		}
		// Using setters as these attributes are mutable
		setName(name);
		setDescription(description);
	}
	
	// Getters
	public String getID() {
		return taskID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	// Setters
	public void setName(String userName) {
		if(userName == null) {
			throw new IllegalArgumentException("Name cannot be null.");
			
		}else if(userName.length() >= 21) {
			throw new IllegalArgumentException("Name cannot be greater than 20 characters long.");
			
		}else {
			this.name = userName;
		}
	}
	
	public void setDescription(String userDescription) {
		if(userDescription == null) {
			throw new IllegalArgumentException("Description cannot be null.");
			
		}else if(userDescription.length() >= 51) {
			throw new IllegalArgumentException("Description cannot be greater than 50 characters long.");
			
		}else {
			this.description = userDescription;
		}
	}

}; // Closing Task class
