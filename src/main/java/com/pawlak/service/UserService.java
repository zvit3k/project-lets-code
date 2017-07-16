package com.pawlak.service;

import com.pawlak.classes.User;

public interface UserService {
	void addUser(User user);
	void deleteUser(User user);
	void updateUser(User user);
	User getUserById(Long id);
	User findByUsername(String username);
}
