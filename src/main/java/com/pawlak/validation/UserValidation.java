package com.pawlak.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pawlak.classes.User;

public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors err) {
		
		User u = (User)o;
		
		if (u.getUsername().length()<=3 || u.getUsername().length()>20)
		{
			err.rejectValue("username","Invalid username - it should contains between 3 and 20 characters.");
		}
		
		Pattern mailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = mailPattern.matcher(u.getMail());
		
		if(!matcher.matches()){
			err.rejectValue("mail", "Invalid mail address!");
		}
		char [] password = u.getPassword().toCharArray();
		char [] confirmedPassword = u.getConfirmPassword().toCharArray();
		
		for(int i=0;i<password.length; i++){
			if(password.length!=confirmedPassword.length){
				err.rejectValue("password", "Provided password have different length!");
				break;
			}
			
			if(password[i]!=confirmedPassword[i]){
				err.rejectValue("password", "Invalid passwords - they do not match!");
				break;
			}
		}
		
		
		
	}

}
