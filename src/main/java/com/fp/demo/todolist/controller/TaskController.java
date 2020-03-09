package com.fp.demo.todolist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fp.demo.services.TaskService;
import com.fp.demo.todolist.model.Task;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping("/tasks")
	public ModelAndView home(HttpServletRequest request) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String username = ((UserDetails) principal).getUsername();

		List<Task> tasks = taskService.findTaskByUsername(username).getTaskList();
		System.out.println(tasks.size());
		ModelAndView mav = new ModelAndView();
		mav.addObject("tasks",tasks);
		mav.addObject("user", username);
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping(value = "/task/{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") int id 
		) {

		

		taskService.delete(id);
		
//		redirectAttributes.addFlashAttribute("css", "success");
//		redirectAttributes.addFlashAttribute("msg", "User is deleted!");
		
		return "redirect:/tasks";

	}

}
