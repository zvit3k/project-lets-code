package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.School;
import com.pawlak.classes.Technology;
import com.pawlak.repositories.AddressRepository;
import com.pawlak.repositories.SchoolRepository;
import com.pawlak.repositories.TechnologyRepository;

@Controller
public class MyController {
	@Autowired
	AddressRepository addressRepository;
	
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
		
		//School s = new School("Sdacademy",3000,120,"Bla bla");
		//School s = schoolRepository.findById(2L);
		
		//Technology t1 = new Technology("Java",s);
		//Technology t2 = new Technology("Csharp",s);
		//Technology t3 = new Technology("Ruby",s);
		//Address ad1 = new Address("Łódź", "Narutowicza 31","34-345", s);
		//Address ad2 = new Address("Poznan", "Jezycka 12","22-725", s);
		
		//technologyRepository.save(t1);
		//technologyRepository.save(t2);
		//technologyRepository.save(t3);
		
		//addressRepository.save(ad1);
		//addressRepository.save(ad2);
		List<Technology> list = technologyRepository.findByTechnologyEquals("Ruby");
		List<School> schools = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			schools.add(list.get(i).getSchool());
		}
		m.addAttribute("schools", schools);
		return "results";
	}
}
