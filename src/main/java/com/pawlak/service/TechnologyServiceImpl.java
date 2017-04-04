package com.pawlak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawlak.classes.Technology;
import com.pawlak.repositories.TechnologyRepository;
@Service
public class TechnologyServiceImpl implements TechnologyService{
	
	private TechnologyRepository technologyRepository;
	
	@Autowired
	public TechnologyServiceImpl(TechnologyRepository technologyRepository){
		this.technologyRepository=technologyRepository;
	}
	
	@Override
	public void addTechnology(Technology t) {
		technologyRepository.save(t);
		
	}

	@Override
	public void deleteTechnology(Technology t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Technology> getTechnology(String technology) {
		return technologyRepository.findByTechnologyEquals(technology);
	}

}
