package com.headerdev.dao;

import java.util.List;

import com.headerdev.model.User;

public interface UserDao {

	User findById(int id);

	User findByUsername(String username);

	void save(User user);

	void deleteBySSO(String sso);

	List<User> findAllUsers();
}
