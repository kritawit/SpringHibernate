package com.headerdev.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.headerdev.model.UserProfile;
import com.headerdev.service.UserProfileService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile> {

	@Autowired
	private UserProfileService userProfileService;

	@Override
	public UserProfile convert(Object element) {
		Integer id = Integer.parseInt((String) element);
		UserProfile profile = userProfileService.findById(id);
		System.out.println("Profile : " + profile);
		return profile;
	}

}
