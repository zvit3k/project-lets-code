package com.pawlak.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawlak.classes.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	List<Person> findByAgeLessThan(int age);
	List<Person> findByNameOrSurname(String name, String surname);
	Person findById(Long id);
}
