package com.pawlak.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pawlak.classes.Address;
import com.pawlak.classes.School;
import com.pawlak.classes.User;
import com.pawlak.service.AddressService;
import com.pawlak.service.SchoolService;
import com.pawlak.service.UserService;

@Controller
public class SchoolController {

	private SchoolService schoolService;
	private UserService userService;
	private AddressService addressService;

	public SchoolController(SchoolService schoolService, UserService userService, AddressService addressService) {
		this.schoolService = schoolService;
		this.userService = userService;
		this.addressService = addressService;
	}

	@RequestMapping(value = "/addschool", method = RequestMethod.GET)
	public String getSchoolForm(Model model) {
		School school = new School();
		model.addAttribute("school", school);
		return "/users/school/add";
	}

	@RequestMapping(value = "/addschool", method = RequestMethod.POST)
	public String sentSchoolForm(@Valid @ModelAttribute School school, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			model.addAttribute("errors", errors);
			return "/users/school/add";
		}

		schoolService.addSchool(school);
		User user = getUser();
		user.setSchool(school);
		userService.updateUser(user);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSchool(@PathVariable Long id, Model model) {

		User user = getUser();
		user.setSchool(null);

		School school = schoolService.getSchoolById(id);
		userService.updateUser(user);
		schoolService.deleteSchool(school);

		return "redirect:/profile";
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String getUpdateSchool(@PathVariable Long id, Model model) {
		School school = schoolService.getSchoolById(id);
		model.addAttribute("school", school);
		return "users/school/update";
	}

	@RequestMapping(value = "/updateS", method = RequestMethod.POST)
	public String sentUpdateSchool(@ModelAttribute School school, BindingResult result, Model model) {
		School s = getUser().getSchool();
		s.setName(school.getName());
		s.setDescription(school.getDescription());
		s.setPrice(school.getPrice());
		s.setNumberOfHours(school.getNumberOfHours());
		schoolService.updateSchool(s);
		return "redirect:/profile";
	}

	@RequestMapping(value = "/addaddress", method = RequestMethod.GET)
	public String newSchoolAddress(Model model) {
		Address address = new Address();
		model.addAttribute("address", address);
		return "users/address/add";
	}

	@RequestMapping(value = "/addaddress", method = RequestMethod.POST)
	public String addSchoolAddress(Address address, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			model.addAttribute("errors", errors);
			return "/users/address/add";
		}

		School s = getUser().getSchool();
		address.setSchool(s);
		addressService.addAddress(address);

		return "redirect:/profile";
	}

	public User getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User user = userService.findByUsername(currentPrincipalName);
		return user;
	}

}
