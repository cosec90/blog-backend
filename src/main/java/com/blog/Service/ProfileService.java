package com.blog.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


import com.blog.Dto.ProfileDto;
import com.blog.Model.Profile;

public interface ProfileService {
	
	boolean addProfileInfo(Profile profile, String username);
	List<Profile> getAllProfiles();
	Profile findById(int id);
	ProfileDto uploadImg(MultipartFile file,String token) throws Exception;
	boolean updateProfile(Profile profile, int pt_id, String token);

}
