package com.pawlak.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pawlak.classes.School;

public class SchoolValidation implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return School.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors err) {

		School school = (School) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(err, "name", "Invalid name - field must not be empty!");

		if (school.getName().length() < 3) {
			err.rejectValue("name", "Invalid name - it should contains more than 3 characters!");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(err, "price", "Invalid price - field must not be empty!");

		if (school.getPrice() <= 0) {

			err.rejectValue("price", "Invalid price - only positive values are allowed!");
		}

		String s = String.valueOf(school.getPrice());

		Pattern pattern = Pattern.compile("\\-*[0-9]+\\.[0-9]+");
		Matcher matcher = pattern.matcher(s);

		if (!matcher.matches()) {
			err.rejectValue("price", "Invalid price - only numeric values are allowed!");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "numberOfHours",
				"Invalid number of hours - field must not be empty!");

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

		ValidationUtils.rejectIfEmptyOrWhitespace(err, "description", "Invalid description - field must not be empty!");

	}
}
