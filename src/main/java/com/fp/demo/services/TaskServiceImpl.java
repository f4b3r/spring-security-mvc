package com.fp.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.demo.todolist.model.TaskDTO;
import com.fp.demo.todolist.repositories.TaskRepository;
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public TaskDTO findTaskByUsername(String username) {
		TaskDTO taskDTO = new TaskDTO(taskRepo.findByUsername(username));
		return taskDTO;
	}

	@Override
	public void delete(Integer id) {
		taskRepo.deleteById(id);
		
	}

}
