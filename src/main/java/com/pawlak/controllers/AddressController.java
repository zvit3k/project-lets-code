package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.Address;
import com.pawlak.classes.School;
import com.pawlak.classes.User;
import com.pawlak.helpers.CITIES;
import com.pawlak.service.AddressService;
import com.pawlak.service.UserService;

@Controller
@RequestMapping(value = "/address")
public class AddressController {

	private UserService userService;
	private AddressService addressService;

	public AddressController(UserService userService, AddressService addressService) {
		this.userService = userService;
		this.addressService = addressService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String newSchoolAddress(Model model) {

		List<String> cities = new ArrayList<>(Arrays.asList(CITIES.Gdynia.toString(), CITIES.Gdańsk.toString(),
				CITIES.Katowice.toString(), CITIES.Kraków.toString(), CITIES.Lublin.toString(),
				CITIES.Olsztyn.toString(), CITIES.Opole.toString(), CITIES.Poznań.toString(), CITIES.Sopot.toString(),
				CITIES.Warszawa.toString(), CITIES.Wrocław.toString(), CITIES.Łódź.toString()));

		Address address = new Address();
		model.addAttribute("cities", cities);
		model.addAttribute("address", address);
		return "users/address/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSchoolAddress(@Valid Address address, BindingResult result, Model model) {

		if (result.hasErrors()) {

			List<FieldError> errors = result.getFieldErrors();
			model.addAttribute("errors", errors);
			List<String> cities = new ArrayList<>(
					Arrays.asList(CITIES.Gdynia.toString(), CITIES.Gdańsk.toString(), CITIES.Katowice.toString(),
							CITIES.Kraków.toString(), CITIES.Lublin.toString(), CITIES.Olsztyn.toString(),
							CITIES.Opole.toString(), CITIES.Poznań.toString(), CITIES.Sopot.toString(),
							CITIES.Warszawa.toString(), CITIES.Wrocław.toString(), CITIES.Łódź.toString()));
			model.addAttribute("cities", cities);

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
