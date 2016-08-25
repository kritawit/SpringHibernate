package com.headerdev.dao;

import java.util.List;

import com.headerdev.model.UserProfile;

public interface UserProfileDao {
	UserProfile findById(int id);

	List<UserProfile> findAll();
}
