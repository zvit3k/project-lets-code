package com.pawlak.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SchoolPriceValidation implements ConstraintValidator<SchoolPrice, Double>{

	@Override
	public void initialize(SchoolPrice arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext arg1) {
		if(value==0.0){
			return false;
		}
		return true;
		
	}


}
