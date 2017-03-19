package com.pawlak.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawlak.classes.Person;
import com.pawlak.repositories.PersonRepository;

@Controller
public class MyController {
	
	@Autowired
	PersonRepository personRepo;
	
	@RequestMapping(value="/people", method=RequestMethod.GET)
	public String getPeopleFrmDB(@RequestParam (value ="search", required=false)int age,Model m){
		m.addAttribute("search", personRepo.findByAgeLessThan(age));
		return "results";
	}
	
	/*
	@RequestMapping(value = "students", method = RequestMethod.GET)
	public String showStudentBySurname(@RequestParam (value = "surname", required = false) String surname, Model model) {
	    model.addAttribute("search", studentService.listStudentsBySurname(surname));
	    return "students";
	}
	*/
	
}
