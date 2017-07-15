package com.pawlak.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pawlak.classes.UserProfile;
import com.pawlak.repositories.UserRepository;

public class UserProfileServiceImpl implements UserProfileService{

	private UserRepository userRepository;
	
	@Autowired
	public UserProfileServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void addUser(UserProfile user) {
		userRepository.save(user);
		
	}

	@Override
	public void updateUser(UserProfile user) {
		userRepository.save(user);
		
	}

	@Override
	public UserProfile getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public void deleteUser(UserProfile user) {
		userRepository.delete(user);
		
	}

}
