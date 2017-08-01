package com.pawlak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pawlak.classes.School;
import com.pawlak.classes.User;
import com.pawlak.service.UserService;

@Controller
public class ProfileController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/profile")
	public String getProfileMainPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);

		boolean hasSchool;

		if (user.getSchool() == null) {
			hasSchool = false;
		} else {
			hasSchool = true;
			School school = user.getSchool();
			model.addAttribute("school", school);
		}

		model.addAttribute("hasSchool", hasSchool);
		return "users/profile";
	}
}
