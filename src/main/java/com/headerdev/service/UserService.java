package com.headerdev.service;

import java.util.List;

import com.headerdev.model.User;

public interface UserService {

	User findById(int id);

	User findByUsername(String username);

	void save(User user);

	void deleteBySSO(String sso);

	List<User> findAllUsers();
	
}
