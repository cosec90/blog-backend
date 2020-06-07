package com.blog.Service;

import com.blog.Model.User;

public interface UserService {

	
	boolean addUser(User user);
	boolean followUser(Long us_id);
	boolean unfollowUser(Long us_id);
	User getUserId(String us_username);
}
