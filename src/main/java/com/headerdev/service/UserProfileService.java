package com.headerdev.service;

import java.util.List;

import com.headerdev.model.UserProfile;

public interface UserProfileService {
	
	List<UserProfile> findAll();

	UserProfile findById(int id);

}
