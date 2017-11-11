package com.pawlak.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SchoolHoursValidation implements ConstraintValidator<SchoolHours, Integer>{

	@Override
	public void initialize(SchoolHours arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext arg1) {
		if(value==0){
			return false;
		}
		return true;
	}

}
