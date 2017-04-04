package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawlak.classes.Technology;
import com.pawlak.repositories.AddressRepository;
import com.pawlak.repositories.SchoolRepository;
import com.pawlak.repositories.TechnologyRepository;
import com.pawlak.service.TechnologyService;

@Controller
// @Transactional
public class MyController {
	//Controller during tests
	@Autowired
	TechnologyService technologyService;
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	TechnologyRepository technologyRepository;

	@Autowired
	SchoolRepository schoolRepository;


	@RequestMapping(value = "/schools", method = RequestMethod.GET)
	public String getSchools(@RequestParam(value = "query", required = false) String technology, Model m) {
		
		List<String> sortChoice = new ArrayList<>(Arrays.asList(new String("Cena"), new String("Godziny")));

		List<Technology> list2 = technologyService.getTechnology(technology);
		List<School> schools = new ArrayList<>();
		for (int i = 0; i < list2.size(); i++) {
			schools.add(list2.get(i).getSchool());
		}
		m.addAttribute("sorting", sortChoice);
		m.addAttribute("schools", schools);
		return "results";
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String getDetails(@PathVariable Long id, Model m) {
		m.addAttribute("school", schoolRepository.findById(id));
		return "details";
	}
	
	@RequestMapping(value = "/results/sort", method = RequestMethod.GET)
	public String getResultSort(@RequestParam(value="sort", required =false) String val, Model m) {
		System.out.println(val);
		m.addAttribute("mozesieuda", val);
		return "details";
	}

}
