package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawlak.classes.School;
import com.pawlak.classes.Technology;
import com.pawlak.repositories.SchoolRepository;
import com.pawlak.service.ReviewService;
import com.pawlak.service.SchoolService;
import com.pawlak.service.TechnologyService;

@Controller
// @Transactional
public class MyController {
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	TechnologyService technologyService;

	@Autowired
	SchoolService schoolService;

	@Autowired
	SchoolService schoolSerivce;

	@RequestMapping(value = "/schools", method = RequestMethod.GET)
	public String getSchools(@RequestParam(value = "query", required = false) String technology, Model m) {
		
		/*List<String> sortingChoice = new ArrayList<>(Arrays.asList(new String("Cena"), new String("Godziny")));

		List<Technology> list2 = technologyService.getTechnology(technology);
		List<School> schools = new ArrayList<>();
		for (int i = 0; i < list2.size(); i++) {
			schools.add(list2.get(i).getSchool());
		}
		
		m.addAttribute("technology", technology);
		m.addAttribute("sortingChoice", sortingChoice);
		m.addAttribute("schools", schools);*/
		return "results";
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String getDetails(@PathVariable Long id, Model m) {
		
		School s = schoolService.getSchoolById(id);
		
		m.addAttribute("school", s);
		m.addAttribute("price", s.getPrice());
		return "details";
	}
	
	@RequestMapping(value = "/sortedResults", method = RequestMethod.GET)
	public String getResultSort(@RequestParam(value="sort", required =false) String sortingCriteria,
								@RequestParam(value="technology", required=false)String technology, 
								Model m) {
		/*
		List<String> sortingChoice = new ArrayList<>(Arrays.asList(new String("Cena"), new String("Godziny")));

		List<Technology> list2 = technologyService.getTechnology(technology);
		List<School> schools = new ArrayList<>();
		for (int i = 0; i < list2.size(); i++) {
			schools.add(list2.get(i).getSchool());
		}
		
		List<School> sortedSchools = schools.stream().sorted((p1,p2) -> {return Double.compare(p2.getPrice(), p1.getPrice());}).collect(Collectors.toList());
		
		m.addAttribute("technology", technology);
		m.addAttribute("sortingChoice", sortingChoice);
		m.addAttribute("schools", sortedSchools);*/
		return "results";
	}
	

}
