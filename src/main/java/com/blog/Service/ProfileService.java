package com.blog.Service;

import java.util.List;

import com.blog.Model.Profile;

public interface ProfileService {
	
	boolean addProfileInfo(Profile profile, String username);
	List<Profile> getAllProfiles();
	
	Profile findById(int id);

}
