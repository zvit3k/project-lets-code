package com.pawlak.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawlak.classes.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
	School findById(List<Integer>list);
}
