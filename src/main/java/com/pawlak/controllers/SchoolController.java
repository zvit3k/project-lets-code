package com.pawlak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.School;
import com.pawlak.classes.User;
import com.pawlak.service.SchoolService;
import com.pawlak.service.UserService;

@Controller
public class SchoolController {
	
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/addschool", method=RequestMethod.GET)
	public String getSchoolForm(Model model){
		School school = new School();
		model.addAttribute("school", school);
		return "/users/school/add";
	}
	
	@RequestMapping(value="/addschool", method=RequestMethod.POST)
	public String sentSchoolForm(@ModelAttribute School school, BindingResult result, Model model){
		schoolService.addSchool(school);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
	   	User user = userService.findByUsername(currentPrincipalName);	
	   	user.setSchool(school);
	   	userService.updateUser(user);
	   
		return "users/profile";
	}
}
