package edu.snhu.tests.task_services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.snhu.task_services.TaskService;
import edu.snhu.task_services.Task;

class TaskServiceTest {

	TaskService task_service;
	Task task;
	
	@BeforeEach
	void createTaskService() {
		task_service = new TaskService();
		task = new Task("1234567890", "Task Name", "Description of task.");

		Assertions.assertNotNull(task_service);
		Assertions.assertNotNull(task);
		
		
	}
	
	@Test
	void testAddingTask() {
		
		Assertions.assertDoesNotThrow(() ->{
			task_service.addTasks(task.getId(), task);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.addTasks("1234567890", task);
		});
	}
	
	@Test
	void testDeletingTask() {
		
		task_service.addTasks(task.getId(), task);
		
		Assertions.assertDoesNotThrow(() ->{
			task_service.deleteTasks(task.getId());
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.deleteTasks("1234567890");
		});
		
	}
	
	@Test
	void testUpdateTaskName() {
		
		//Adding a valid task to the service
		task_service.addTasks(task.getId(), task);
		//Good name and good Id
		Assertions.assertDoesNotThrow(() ->{
			task_service.updateTaskName(task.getId(),"Good Name");
		});
		//Name is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.updateTaskName(task.getId(), "Baaadddddddddd Naaammmeee");
		});
		//Description can't be null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.updateTaskName(task.getId(), null);
		});		
		//Can't have null Id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.updateTaskName(null, "Good Name");
		});
		//Can't find unique Id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.updateTaskName("1", "Good Name");
		});			
	}

	@Test
	void testUpdateTaskDesc() {
		
		task_service.addTasks(task.getId(), task);
		
		Assertions.assertDoesNotThrow(() ->{
			task_service.updateTaskDescription(task.getId(),"Good description");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.updateTaskDescription(task.getId(), "BBBBBBBBBBBBBBBBBBaaaaaaaaaaaaaaaaaaaadddddddddddddd deeeeeeescriiiiiiiiiiiiiiiiipppptiiiiiiiiionnnnnnnnnnnnnnnnnn");
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.updateTaskDescription(task.getId(), null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.updateTaskDescription(null, "Good description.");
		});		
	}	
}
