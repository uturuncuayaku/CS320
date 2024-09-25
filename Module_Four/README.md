# Module Four - Customer Requirements
--- 

We are developing unit tests using JUnit to identify potential errors in the mobile application, ensuring the code aligns with customer requirements. In this milestone of our mobile application project, we will implement task management services that allow users to add, update, and delete task objects. 

# Task Requirements

- The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable. 
- The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null. 
- The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null. 

# Task Service Requirements 
 
- The task service shall be able to add tasks with a unique ID. 
- The task service shall be able to delete tasks per task ID. 
- The task service shall be able to update task fields per task ID. The following fields are updatable: Name, and Description. 
