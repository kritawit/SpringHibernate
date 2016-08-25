package com.headerdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.headerdev.dao.UserDao;
import com.headerdev.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

	@Override
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setState(1);
		userDao.save(user);
	}

	@Override
	public void deleteBySSO(String sso) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAllUsers();
	}

}
