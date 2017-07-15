package com.pawlak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.UserProfile;

@Controller
public class RegisterController {
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegisterForm(Model model){
		UserProfile user  = new UserProfile();
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String sentRegisterForm(@ModelAttribute UserProfile user, Model model){
		
		System.out.println(user);
		
		return "register";
	}
	
}
