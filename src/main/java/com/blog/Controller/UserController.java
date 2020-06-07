package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Dao.UserDao;
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
	
	// test api
	@PostMapping("/userId/{username}")
	public User getUserId(@PathVariable("username")String username) {
		
		
		return userDao.getUserId(username);
	}
	
	@PostMapping("/addfollowers/{userId}")
	public boolean addFollowers(@PathVariable("userId")int userId) {
		
		followersServiceImpl.addFollowers(userId);
		return true;
	}
	
	//test api
	@PostMapping("/addProfileInfo/{username}")
	public List<Profile> addProfileInfo(@PathVariable("username")String username, @RequestBody Profile profile) {
		
		profileServiceImpl.addProfileInfo(profile, username);
		return profileServiceImpl.getAllProfiles();
	}
	
	@PostMapping("/getProfile/{id}")
	public Profile getProfiles(@PathVariable("id")int id){
		
		return profileServiceImpl.findById(id);
	}


}