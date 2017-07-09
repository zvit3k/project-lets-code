package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pawlak.classes.Address;
import com.pawlak.classes.School;
import com.pawlak.classes.SchoolWrapper;
import com.pawlak.helpers.SORTINGCRITERIA;
import com.pawlak.service.AddressService;

@Controller
public class SortingController {

	@Autowired
	AddressService addressService;

	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	public String getResultSort(@RequestParam(value = "sort", required = false) String sortingCriteria,
			@RequestParam(value = "city", required = false) String city, Model m) {

		List<String> sortingChoice = new ArrayList<>(Arrays.asList(SORTINGCRITERIA.CENA.toString(),
				SORTINGCRITERIA.OCENA.toString(), SORTINGCRITERIA.NAZWA.toString()));

		List<Address> addresses = addressService.getAddressesEquals(city);
		List<School> schools = new ArrayList<>();
		for (Address a : addresses) {
			schools.add(a.getSchool());
		}
		List<School> sortedSchools = null;

		if (sortingCriteria.equals("CENA")) {
			sortedSchools = schools.stream().sorted((p1, p2) -> {
				return Double.compare(p1.getPrice(), p2.getPrice());
			}).collect(Collectors.toList());

		} else if (sortingCriteria.equals("OCENA")) {
			sortedSchools = schools.stream().sorted((p1, p2) -> {
				return Double.compare(p1.getAvarageRating(), p2.getAvarageRating());
			}).collect(Collectors.toList());

		} else if (sortingCriteria.equals("NAZWA")) {
			sortedSchools = schools.stream().sorted((p1, p2) -> {
				return p1.getName().compareTo(p2.getName());
			}).collect(Collectors.toList());

		}

		SchoolWrapper wrapper = new SchoolWrapper();
		wrapper.setList(sortedSchools);

		m.addAttribute("city", city);
		m.addAttribute("sortingChoice", sortingChoice);
		m.addAttribute("wrapper", wrapper);

		return "/schools/results";
	}
}
