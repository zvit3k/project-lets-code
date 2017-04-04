package com.pawlak.service;

import java.util.List;

import com.pawlak.classes.Technology;

public interface TechnologyService {
	void addTechnology(Technology t);
	void deleteTechnology(Technology t);
	List<Technology> getTechnology(String technology);
}
