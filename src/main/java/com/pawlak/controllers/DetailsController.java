package com.pawlak.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.DetailsWrapper;
import com.pawlak.helpers.COURSETYPE;
import com.pawlak.helpers.Technologies;

@Controller
@RequestMapping(value = "/det")
public class DetailsController {

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getDetailsForSchool(Model model) {
		DetailsWrapper wrapper = new DetailsWrapper();
		
		List<Technologies> technologies = new ArrayList<>(Arrays.asList(new Technologies[]{Technologies.CPlusPlus,Technologies.CSS, Technologies.CSharp}));
		List<COURSETYPE> types = new ArrayList<>(Arrays.asList(new COURSETYPE[]{COURSETYPE.BOOTCAMP}));

		model.addAttribute("technologies", technologies);
		model.addAttribute("types", types);
		model.addAttribute("wrapper", wrapper);
		
		return "/users/details/add";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String postDetailsForSchool(@Valid DetailsWrapper wrapper, BindingResult result, HttpServletRequest request, Model model) {
		if(result.hasFieldErrors()){
			List<FieldError> errors = result.getFieldErrors();
			
			model.addAttribute("errors", errors);
			return "/users/details/add";
		}
		
		return "/users/profile";
	}
}
