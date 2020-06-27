package com.blog.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dao.UserDao;
import com.blog.Dto.UserDto;
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

	@Override
	public UserDto getUserByUsername(String us_username) {
		User user = userDao.findByUsername(us_username);
		
		return getUserDto(user);
	}
	
	@SuppressWarnings("unused")
	private UserDto getUserDto(User entity) {
		return UserDto.builder().us_username(entity.getUs_username()).us_id(entity.getUs_id())
		.build();
		
	}

	
	
	
	

}
