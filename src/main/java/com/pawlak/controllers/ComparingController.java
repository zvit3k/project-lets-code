package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.School;
import com.pawlak.classes.SchoolWrapper;
import com.pawlak.service.SchoolService;

@Controller
@RequestMapping
public class ComparingController {

	@Autowired
	SchoolService schoolService;

	@RequestMapping(value = "/compare", method = RequestMethod.POST)
	public String compareSchools(@ModelAttribute SchoolWrapper wrapper, BindingResult bindingResult, Model model) {

		List<School> schools = new ArrayList<>();

		for (School s : wrapper.getList()) {
			if (s.getId() != null) {
				School school = schoolService.getSchoolById(s.getId());
				s.setName(school.getName());
				s.setDescription(school.getDescription());
				s.setPrice(school.getPrice());
				s.setReviews(school.getReviews());
				schools.add(school);
			}
		}

		model.addAttribute("schools", schools);

		return "/schools/compare";
	}

}
