package com.fp.demo.todolist.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fp.demo.todolist.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
	List<Task> findByUsername(String username);
}
