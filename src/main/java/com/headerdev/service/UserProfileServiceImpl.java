package com.headerdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.headerdev.dao.UserProfileDao;
import com.headerdev.model.UserProfile;

@Service
public class UserProfileServiceImpl implements UserProfileService{

	@Autowired
	private UserProfileDao dao;
	
	@Override
	public List<UserProfile> findAll() {
		return dao.findAll();
	}

	@Override
	public UserProfile findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

		
	
}