package com.pawlak.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pawlak.classes.User;
import com.pawlak.service.UserService;
import com.pawlak.validation.UserValidation;

@Controller
public class RegisterController {
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserValidation());
    }
	
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "users/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String sentRegisterForm(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		
		if(result.hasErrors()){
			List<String> errors = result.getFieldErrors().stream().map(e->e.getCode()).map(e->e.toString()).collect(Collectors.toList());
			model.addAttribute("errors", errors);
			return "users/register";
		}

		userService.addUser(user);
		return "main";
	}

}
