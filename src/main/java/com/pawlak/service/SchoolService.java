package com.pawlak.service;

import com.pawlak.classes.School;

public interface SchoolService {
	void addSchool(School s);
	void updateSchool(School s);
	void deleteSchool(School s);
	School getSchoolById(Long id);
		
}
