package edu.snhu.tests.task_services;

import java.util.function.Supplier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.snhu.task_services.Task;

class TaskTest {

    @Test
    public void testValidTask() {
    	
        //Test with a valid ID
        Task validTask = new Task("validId", "name", "description");
        Assertions.assertNotNull(validTask);
        
        //Test with all null values
        Assertions.assertThrows(IllegalArgumentException.class,()->{
        	new Task(null, null, null);
        });
        //Test with one null value
        Assertions.assertThrows(IllegalArgumentException.class,()->{
        	new Task(null, "valNam", "valid desc");
        });
        //Test with two valid values, and one null value
        Assertions.assertThrows(IllegalArgumentException.class,()->{
        	new Task("12", null, "valid description");
        });
        
        //Test with two valid values, and one null value
        Assertions.assertThrows(IllegalArgumentException.class,()->{
        	new Task("123", "name", null);
        });
        
    }
    
	@Test
	void testId() {
		Task task = new Task("1234567890", "name", "description");
		Assertions.assertNotNull(task);
		
		//Tests null id
        Supplier<Task> task1 = () -> new Task(null, "name", "description");
		Assertions.assertThrows(IllegalArgumentException.class, task1::get);
		
		//Test getting id
		Task test_task = new Task("1234567890", "Task Name", "Task Description");
		String id = test_task.getId();
		Assertions.assertEquals(id, "1234567890");
		
		//Tests too long of an Id
		Supplier<Task> task2 = () -> new Task("toolongofidthrowsexception", "name", "description");
		Assertions.assertThrows(IllegalArgumentException.class,task2::get);
	}
	
	@Test
	void testName() {
		
		//Test getName function
        String validName = "valid name";
		Task validTask = new Task("validId", validName, "description");
        String getName = validTask.getName();
        Assertions.assertEquals(getName, validName);   	

		//Test null name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", null, "description");
		});
		
		//Tests long name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "toolongofanamethrowsexception", "description");
		});
		
		//Test getting name and updating to a new name
		String original_name = "Task Name";
		Task original_task = new Task("1234567890", original_name, "Task Description");
		String old_name = original_task.getName();
		Assertions.assertEquals(old_name, original_name);

		//Test updating name
		String new_name = "New Name";
		original_task.setName(new_name);
		Assertions.assertEquals(new_name, original_task.getName());
		
		//Test updating name to null
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			original_task.setName(null);
		});
		
	}
	
	@Test
	void testDesc() {
		//Test getDescription function
		String desc = "description";
		Task validTask = new Task("validId", "name", desc);
		String getDesc = validTask.getDescription();
		Assertions.assertEquals(desc, getDesc);
 
		//Test setDescription function
		String updateDesc = "new description";
		validTask.setDescription(updateDesc);
		String desc1 = validTask.getDescription();
		Assertions.assertEquals(updateDesc, desc1);
		
		//Test null description
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "name", null);
		});
		
		//Test too long of a description
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1234567890", "name", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		});
		
		//Test getting description and updating to a new description
		String original_description = "Task description";
		Task test_task = new Task("1234567890", "Task Name", original_description);
		String get_desc = test_task.getDescription();
		Assertions.assertEquals(get_desc, original_description);

		//Test updating description to valid name
		String new_desc = "New Description";
		test_task.setDescription(new_desc);
		Assertions.assertEquals(new_desc, test_task.getDescription());	
		
		//Test updating description to null
		Assertions.assertThrows(IllegalArgumentException.class,()->{
			test_task.setDescription(null);
		});
		
	}

}
