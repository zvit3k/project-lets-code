package com.pawlak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
	
	@RequestMapping(value="/profile")
	public String getProfileMainPage(){
		return "users/profile";
	}
}
