package com.pawlak.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pawlak.classes.School;

public class SchoolValidation implements Validator {
	
	@Autowired
	MessageSource messageSource;
	
	@Override
	public boolean supports(Class<?> aClass) {
		return School.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors err) {

		School school = (School) o;

		if (school.getName().length() < 3 || school.getName().length() > 20 || school.getName().equals(null)) {
			err.rejectValue("name", "Invalid name - it should contains between 3 and 20 characters.");
		}

		if (school.getPrice() <= 0) {
			err.rejectValue("price", "Invalid price - only positive values are allowed!");
		}

		String s = String.valueOf(school.getPrice());

		Pattern pattern = Pattern.compile("[0-9]+\\.[0-9]+");
		Matcher matcher = pattern.matcher(s);

		if (!matcher.matches()) {
			err.rejectValue("price", "Invalid price - only numeric values are allowed!");
		}

		if (school.getNumberOfHours() <= 0) {
			err.rejectValue("numberOfHours", "Invalid number of hours - only positive values are allowed!");
		}

		char[] numberOfHours = String.valueOf(school.getNumberOfHours()).toCharArray();

		for (char c : numberOfHours) {
			if (!Character.isDigit(c)) {
				err.rejectValue("numberOfHours", "Invalid number of hours - it should contains only numbers!");
				return;
			}
		}
	}
}
