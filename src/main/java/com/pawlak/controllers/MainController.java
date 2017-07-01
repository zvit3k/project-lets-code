package com.pawlak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.Address;
import com.pawlak.classes.School;

@Controller
public class MainController {

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String getMainPage() {
		return "main";
	}
	

}
