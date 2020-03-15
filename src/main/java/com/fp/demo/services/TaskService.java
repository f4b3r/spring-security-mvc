package com.fp.demo.services;

import com.fp.demo.services.model.TaskEntity;
import com.fp.demo.todolist.model.Task;

public interface TaskService {
	
	TaskEntity findTaskByUsername(String username);
	void delete(Long id);
	void addTask(Task task);
	
	
}
