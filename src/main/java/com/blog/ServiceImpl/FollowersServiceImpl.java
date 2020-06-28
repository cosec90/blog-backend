package com.blog.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.Dao.FollowersDao;
import com.blog.Dao.UserDao;
import com.blog.Model.Followers;
import com.blog.Model.User;
import com.blog.Service.FollowersService;
import com.blog.Utils.JwtUtil;

@Service
public class FollowersServiceImpl  implements FollowersService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FollowersDao followersDao;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Override
	public boolean addFollowers(int id,String token) {
		//id is of the user to be followed
		String username = jwtUtil.extractUsername(token.substring(7));
		User user = userDao.findByUsername(username);
		
		Followers followers = new Followers();
		followers.setFl_friendId(id);
		followers.setUser(user);
		followersDao.save(followers);
		return true;
	}

	@Override
	public List<Followers> getUserFollowers(String token) {

		String username = jwtUtil.extractUsername(token.substring(7));
		int user_id = userDao.getUserId(username);
	
		List<Followers> followers = followersDao.getUserFollower(user_id);
		return followers;
	}

	@Override
	public boolean deleteFollower(int fl_id) {
		
		Followers follower = followersDao.getFollowerById(fl_id);
		followersDao.delete(follower);
		
		return true;
	}

}
