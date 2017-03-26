package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.School;
import com.pawlak.classes.TECHNOLOGIES;
import com.pawlak.classes.Technology;
import com.pawlak.repositories.PersonRepository;
import com.pawlak.repositories.SchoolRepository;
import com.pawlak.repositories.TechnologyRepository;

@Controller
public class MyController {
	
	@Autowired
	TechnologyRepository technologyRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	/*
	@RequestMapping(value="/people", method=RequestMethod.GET)
	public String getPeopleFrmDB(@RequestParam (value ="query", required=false)String value,Model m){
		//m.addAttribute("listByAge", personRepo.findByAgeLessThan(age));
		m.addAttribute("list", personRepo.findByNameOrSurname(value, value));
		
		return "results";
	}*/
	/*
	@RequestMapping(value="/details/{id}", method=RequestMethod.GET)
	public String getDetails(@PathVariable Long id, Model m){
		Person p = personRepo.findById(id);
		m.addAttribute("person", p);
		return "details";
	}
	*/
	
	@RequestMapping(value="/schools", method=RequestMethod.GET)
	public String getSchools(Model m){
		
		//School s = new School("CODACADEMY",3000,160,"Powstała w 2000 roku");
		//School s = schoolRepository.findById(2L);
		//Technology t = new Technology(TECHNOLOGIES.CSS, s);
		//Technology t1 = new Technology(TECHNOLOGIES.HTML, s);
		
		//technologyRepository.save(t);
		//technologyRepository.save(t1);
		
		//m.addAttribute("schools", schoolRepository.findAll());
		return "results";
	}
}
