package com.pawlak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawlak.classes.School;
import com.pawlak.repositories.SchoolRepository;

@Service
public class SchoolServiceImpl implements SchoolService {

	private SchoolRepository schoolRepository;

	@Autowired
	public SchoolServiceImpl(SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}

	@Override
	public void addSchool(School s) {
		schoolRepository.save(s);

	}

	@Override
	public void deleteSchool(School s) {
		// TODO Auto-generated method stub

	}

	@Override
	public School getSchoolById(Long id) {
		return schoolRepository.findById(id);
	}

}
