package com.fp.demo.services;

import com.fp.demo.todolist.model.Task;
import com.fp.demo.todolist.model.TaskDTO;

public interface TaskService {
	
	TaskDTO findTaskByUsername(String username);
	void delete(Long id);
	void addTask(Task task);
	
	
}
