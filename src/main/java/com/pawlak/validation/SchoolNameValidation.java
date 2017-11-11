package com.pawlak.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SchoolNameValidation implements ConstraintValidator<SchoolName, String>{

	@Override
	public void initialize(SchoolName arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		return !value.matches("A-Z[a-z\\s]*");
	}

}
