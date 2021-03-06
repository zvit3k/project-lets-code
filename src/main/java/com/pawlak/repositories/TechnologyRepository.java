package com.pawlak.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawlak.classes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer	>{
	Technology findByTechnologyEquals(String name);
	Technology findOneById(Long id);
	
}
