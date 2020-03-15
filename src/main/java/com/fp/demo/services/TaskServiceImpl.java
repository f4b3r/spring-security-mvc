package com.fp.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.demo.services.model.TaskEntity;
import com.fp.demo.todolist.model.Task;
import com.fp.demo.todolist.repositories.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public TaskEntity findTaskByUsername(String username) {
		TaskEntity taskDTO = new TaskEntity(taskRepo.findByUsername(username));
		return taskDTO;
	}

	@Override
	public void delete(Long id) {
		taskRepo.deleteById(id);
		
	}

	@Override
	public void addTask(Task task) {
		taskRepo.save(task);
		
	}


	
}
