package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Dao.UserDao;
import com.blog.Model.Followers;
import com.blog.Model.Profile;
import com.blog.Model.User;
import com.blog.ServiceImpl.FollowersServiceImpl;
import com.blog.ServiceImpl.ProfileServiceImpl;
import com.blog.ServiceImpl.UserImpl;

@RequestMapping("/api")
@RestController()
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	
	@Autowired
	private UserImpl userImpl;
	
	@Autowired
	private FollowersServiceImpl followersServiceImpl;
	
	@Autowired
	private ProfileServiceImpl profileServiceImpl;
	
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		
		return userDao.findAll();
	}
	
	@PostMapping("/signup")
	public void signUp(@RequestBody User user) {
		
		userImpl.addUser(user);
		
	}
	
	public boolean deleteUser(Long us_id) {
	
		
		return true;
	}
	
	//follower api's
	@PostMapping("/addfollower/{userId}")
	public boolean addFollowers(@PathVariable("userId")int userId,@RequestHeader(value = "Authorization")String token) {
		
		followersServiceImpl.addFollowers(userId, token);
		return true;
	}
	
	@GetMapping("/getUserFollowers")
	public List<Followers> getUserFollowers(@RequestHeader(value = "Authorization")String token){
		
		List<Followers> followers = followersServiceImpl.getUserFollowers(token);
		return followers;
	}
	


}