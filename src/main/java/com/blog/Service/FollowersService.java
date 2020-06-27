package com.blog.Service;

import java.util.List;

import com.blog.Model.Followers;

public interface FollowersService {
	
	boolean addFollowers(int id, String token);
	List<Followers> getUserFollowers(String token);

}
