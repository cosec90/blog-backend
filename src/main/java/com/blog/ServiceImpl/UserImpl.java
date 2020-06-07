package com.blog.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dao.UserDao;
import com.blog.Model.User;
import com.blog.Service.UserService;

@Service
public class UserImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean addUser(User user) {
		userDao.save(user);
		return true;
	}

	@Override
	public boolean followUser(Long us_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unfollowUser(Long us_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserId(String us_username) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
