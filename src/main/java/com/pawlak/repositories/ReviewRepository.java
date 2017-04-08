package com.pawlak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawlak.classes.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
}
