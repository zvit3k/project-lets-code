package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawlak.classes.Address;
import com.pawlak.classes.Review;
import com.pawlak.classes.School;
import com.pawlak.classes.Technology;
import com.pawlak.helpers.SORTINGCRITERIA;
import com.pawlak.service.AddressService;
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
	AddressService addressService;

	@RequestMapping(value = "/schools", method = RequestMethod.GET)
	public String getSchools(@RequestParam(value = "query", required = false) String city, Model m) {
		
		List<String> sortingChoice = new ArrayList<>(Arrays.asList(SORTINGCRITERIA.Cena.toString()));
		//List<String> sortingChoice = new ArrayList<>(Arrays.asList(new String("COS")));
		
		List<Address> addresses = addressService.getAddressesEquals(city);
		List<School> schools = new ArrayList<>();
		for(Address a :addresses){
			schools.add(a.getSchool());
		}
		
		m.addAttribute("city", city);
		m.addAttribute("sortingChoice", sortingChoice);
		m.addAttribute("schools", schools);
		return "results";
	}

	@RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
	public String showDetails(@PathVariable Long id, Model m) {
		
		School s = schoolService.getSchoolById(id);
		
		List<Review> reviews = s.getReviews();
		
		List<Integer> rating = new ArrayList<>(Arrays.asList(
				new Integer(1), 
				new Integer(2),
				new Integer(3),
				new Integer(4),
				new Integer(5)));
		
		m.addAttribute("review", new Review());
		m.addAttribute("rating", rating);
		m.addAttribute("reviews", reviews);
		m.addAttribute("school", s);
		return "details";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public String postDetails(@ModelAttribute Review review, @ModelAttribute(value="id") Long id) {
		School s = schoolService.getSchoolById(id);
		
		Calendar date = Calendar.getInstance();
		review.setDate(date);
		Review r = new Review(review.getNickname(),review.getUserReview(), review.getRating(),review.getDate());
		r.setSchool(s);
		reviewService.addReview(r);
		
		return "done";
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
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addSchool(Model m) {
		
		School s = schoolService.getSchoolById(2L);
		Technology t = technologyService.getById(4L);
		s.getTechnologies().add(t);
		schoolService.addSchool(s);
		
		return "details";
	}
	
	
	

}
