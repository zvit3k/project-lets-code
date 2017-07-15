package com.pawlak.service;

import com.pawlak.classes.UserProfile;

public interface UserProfileService {
	void addUser(UserProfile user);
	void deleteUser(UserProfile user);
	void updateUser(UserProfile user);
	UserProfile getUserById(Long id);
}
