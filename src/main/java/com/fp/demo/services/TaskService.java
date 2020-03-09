package com.fp.demo.services;

import com.fp.demo.todolist.model.TaskDTO;

public interface TaskService {
	
	TaskDTO findTaskByUsername(String username);
	void delete(Integer id);
}
