package com.pawlak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawlak.classes.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
	School findById(Long id);
	
}
