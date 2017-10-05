package com.pawlak.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.School;
import com.pawlak.classes.User;
import com.pawlak.service.SchoolService;
import com.pawlak.service.UserService;
import com.pawlak.validation.SchoolValidation;

@Controller
public class SchoolController {
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new SchoolValidation());
    }
	
	@Autowired
	SchoolService schoolService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/addschool", method = RequestMethod.GET)
	public String getSchoolForm(Model model) {
		School school = new School();
		model.addAttribute("school", school);
		return "/users/school/add";
	}

	@RequestMapping(value = "/addschool", method = RequestMethod.POST)
	public String sentSchoolForm(@Valid @ModelAttribute School school, BindingResult result, Model model) {
		
		if(result.hasErrors()){
			List<String> errors = result.getFieldErrors().stream().map(e->e.getCode()).map(e->e.toString()).collect(Collectors.toList());

			model.addAttribute("errors", errors);
			return "/users/school/add";
		}
		
		schoolService.addSchool(school);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		user.setSchool(school);
		userService.updateUser(user);

		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSchool(@PathVariable Long id, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		user.setSchool(null);
		
		School school = schoolService.getSchoolById(id);
		userService.updateUser(user);
		schoolService.deleteSchool(school);

		return "redirect:/profile";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String getUpdateSchool(@PathVariable Long id, Model model) {
		/*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);*/
		School school = schoolService.getSchoolById(id);
		model.addAttribute("school", school);
		return "users/school/update";
	}
	
	@RequestMapping(value = "/updateS", method = RequestMethod.POST)
	public String sentUpdateSchool(@ModelAttribute School school, BindingResult result, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		
		School s = user.getSchool();
		s.setName(school.getName());
		s.setDescription(school.getDescription());
		s.setPrice(school.getPrice());
		s.setNumberOfHours(school.getNumberOfHours());
		schoolService.updateSchool(s);
		return "redirect:/profile";
	}
}
