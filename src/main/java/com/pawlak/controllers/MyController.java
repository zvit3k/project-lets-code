package com.pawlak.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.Person;
import com.pawlak.repositories.PersonRepository;

@Controller
public class MyController {
	
	@Autowired
	PersonRepository personRepo;
	
	@RequestMapping(value="/db", method=RequestMethod.GET)
	public String getPeopleFrmDB(Model m){
	
		List<Person> people = personRepo.findAll();
		m.addAttribute("people", people);
		return "results";
	}
}
