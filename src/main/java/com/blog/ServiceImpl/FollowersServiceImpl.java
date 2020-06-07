package com.blog.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dao.FollowersDao;
import com.blog.Dao.UserDao;
import com.blog.Model.Followers;
import com.blog.Model.User;
import com.blog.Service.FollowersService;

@Service
public class FollowersServiceImpl  implements FollowersService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FollowersDao followersDao;
	
	@Override
	public boolean addFollowers(int us_id) {
		//get username of the current user from token
		String username = "shahid2";
		User user = userDao.findByUsername(username);
		Followers followers =new Followers();
		followers.setUser(user);
		followers.setFl_followers(us_id);
		followersDao.save(followers);
		return true;
	}

}
