package com.blog.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.Dao.UserDao;
import com.blog.Model.User;


@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		
		return new org.springframework.security.core.userdetails.User(user.getUs_username(),user.getUs_password(),new ArrayList<>());
	}

}
