/**
 * @Author Andres
 * SNHU
 * 9/29/2024
 * Prof. Parul Hirpara
 * 
 */

package edu.snhu.task_services;

import java.util.HashMap;

public class TaskService {
	
	private HashMap<String, Task> task_map;
	
	public TaskService() {
		task_map = new HashMap<>();
	}
	
	public boolean addTasks(String id) {
		if (task_map.containsKey(id)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteTasks(String id) {
		if (task_map.containsKey(id)) {
			task_map.remove(id);
			return true;
		}else {
			return false;
		}
	}
	
	public void updateTaskName(String id, String name) {
		if (task_map.containsKey(id)) {
			Task updateTask = task_map.get(id);
			updateTask.setName(name);
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public void updateTaskDescription(String id, String desc) {
		if (task_map.containsKey(id)) {
			Task updateTask = task_map.get(id);
			updateTask.setName(desc);
		}else {
			throw new IllegalArgumentException();
		}
	}
}
