package com.blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dao.ProfileDao;
import com.blog.Dao.UserDao;
import com.blog.Model.Profile;
import com.blog.Model.User;
import com.blog.Service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean addProfileInfo(Profile profile, String username) {
		
		User user = userDao.findByUsername(username);
		profile.setUseProfr(user);
		profileDao.save(profile);
		return true;
	}

	public List<Profile> getProfiles(){
		
		
		return profileDao.findAll();
	}

	@Override
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile findById(int id) {
		
		return profileDao.findById(id);
	}
	

	
	
}
