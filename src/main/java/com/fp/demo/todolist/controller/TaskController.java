package com.fp.demo.todolist.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fp.demo.services.TaskService;
import com.fp.demo.todolist.model.Task;

@Controller
public class TaskController {

	private static final Logger LOGGER = LogManager.getLogger();

	
	@Autowired
	private TaskService taskService;

	@RequestMapping("/tasks")
	public ModelAndView home(HttpServletRequest request) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();
		LOGGER.debug("redirect home user: " + username);
		List<Task> tasks = taskService.findTaskByUsername(username).getTaskList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("task", new Task());
		mav.addObject("tasks",tasks);
		mav.addObject("user", username);
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/task/{id}/delete",method = RequestMethod.POST)
	public String deleteTask(@PathVariable("id") Long id 
		) {

		LOGGER.debug("CALLING DELETE Task on taskID:" + id);

		taskService.delete(id);
		
		LOGGER.debug("DELETED Task with ID:" + id);
//		redirectAttributes.addFlashAttribute("css", "success");
//		redirectAttributes.addFlashAttribute("msg", "User is deleted!");
		
		return "redirect:/tasks";

	}
	
	@RequestMapping(value = "/task/add" ,method = RequestMethod.POST)
	public String addTask(@ModelAttribute("task") Task task 
		) {

		LOGGER.debug("CALLING add Task with description :" + task.getDescription());
		task.setLastUpdate(new Date(System.currentTimeMillis()));
		taskService.addTask(task);
		
		LOGGER.debug("created new task - description :" + task.getDescription());
//		redirectAttributes.addFlashAttribute("css", "success");
//		redirectAttributes.addFlashAttribute("msg", "User is deleted!");
		
		return "redirect:/tasks";

	}
	

}
