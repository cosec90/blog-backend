package com.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.blog.Dto.ProfileDto;
import com.blog.Model.Profile;
import com.blog.ServiceImpl.ProfileServiceImpl;
import com.blog.Utils.JwtUtil;

@RequestMapping("/api")
@RestController()
@CrossOrigin(origins = "*")
public class ProfileController {
	
	@Autowired
	ProfileServiceImpl profileService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/addProfile")
	public boolean addProfile(@RequestBody Profile profile,@RequestHeader(value = "Authorization")String token) {
		
		String username = jwtUtil.extractUsername(token.substring(7));
		profileService.addProfileInfo(profile, username);
		return true;
	}
	
	@PostMapping("/uploadProfileImg")
	public ProfileDto uploadProfileImg(@RequestParam("file")MultipartFile file,@RequestHeader(value = "Authorization")String token) throws Exception{
		
		
		ProfileDto profile = profileService.uploadImg(file,token);
		
		
		return profile;
	}
	
	@PutMapping("/updateProfile/{postId}")
	public boolean updateProfile(@RequestBody Profile profile,@PathVariable("postId")int id,@RequestHeader(value = "Authorization")String token) {
		
		profileService.updateProfile(profile, id, token);
		return true;
	}
	
}
