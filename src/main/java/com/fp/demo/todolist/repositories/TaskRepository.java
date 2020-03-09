package com.fp.demo.todolist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fp.demo.todolist.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{
	List<Task> findByUsername(String username);
}
