package com.fp.demo.services.model;

import java.util.List;

import com.fp.demo.todolist.model.Task;

public class TaskEntity {

	private List<Task> taskList;

	
	public TaskEntity(List<Task> taskList) {
		super();
		this.taskList = taskList;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	
}
