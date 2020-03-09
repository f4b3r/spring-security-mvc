package com.fp.demo.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

//	@GetMapping("/login")
//	public String  displayLogin(Model model) {
//		User user = new User();
//		model.addAttribute("user", user);
//		return "login";
//	}
//	
//	@PostMapping("/login")
//	public String  performLogin(@ModelAttribute("user") User user, Model model) {
//		
//		//call service
//		model.addAttribute("user", user);
//		return "login";
//	}
	
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }
}
