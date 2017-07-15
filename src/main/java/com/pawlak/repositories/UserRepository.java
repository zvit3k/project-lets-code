package com.pawlak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawlak.classes.UserProfile;

public interface UserRepository extends JpaRepository<UserProfile, Integer>{
	UserProfile findById(Long id);
}
