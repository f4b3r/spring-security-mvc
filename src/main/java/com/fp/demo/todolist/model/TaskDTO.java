package com.fp.demo.todolist.model;

import java.util.List;

public class TaskDTO {

	private List<Task> taskList;

	
	public TaskDTO(List<Task> taskList) {
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
