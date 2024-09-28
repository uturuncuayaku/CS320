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
		
		//Test adding a task to the service
		Assertions.assertDoesNotThrow(() ->{
			task_service.addTasks(task.getId(), task);
		});
		
		//Test adding a duplicate task
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.addTasks("1234567890", task);
		});
		
		//Test adding a null id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.addTasks(null, task);
		});
		
		//Test adding a null task
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.addTasks("1234567890", null);
		});
		
		//Test adding a long task id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.addTasks("19234123567890", task);
		});
		
		//Test adding two more tasks
		Task task1 = new Task("9234567890", "Task Name", "Description of task.");
		Task task2 = new Task("8234567890", "Task Name", "Description of task.");
		Assertions.assertDoesNotThrow(() ->{
			task_service.addTasks(task1.getId(), task1);
		});
		Assertions.assertDoesNotThrow(() ->{
			task_service.addTasks(task2.getId(), task2);
		});		

	}
	
	@Test
	void testDeletingTask() {
		
		task_service.addTasks(task.getId(), task);
		
		//Test deleting a task
		Assertions.assertDoesNotThrow(() ->{
			task_service.deleteTasks(task.getId());
		});
		
		//Test ensuring task was deleted
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.deleteTasks("1234567890");
		});
		
		//Test deleting too long of an Id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.deleteTasks("12334567890");
		});
		
		//Tests deleting a null task
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.deleteTasks(null);
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
		
		//Name can't be null
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
		
		//Can't find too long of an Id
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			task_service.updateTaskName("11111111111111111111111111", "Good Name");
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
