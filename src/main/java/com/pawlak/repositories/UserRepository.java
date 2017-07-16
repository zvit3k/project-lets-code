package com.pawlak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawlak.classes.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(Long id);
	User findByUsername(String username);
}
