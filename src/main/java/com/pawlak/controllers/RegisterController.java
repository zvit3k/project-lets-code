package com.pawlak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.User;
import com.pawlak.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	UserService userProfileService;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegisterForm(Model model){
		User user  = new User();
		model.addAttribute("user", user);
		return "users/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String sentRegisterForm(@ModelAttribute User user,BindingResult result, Model model){
		userProfileService.addUser(user);
		System.out.println(user);
		return "main";
	}
	
}
