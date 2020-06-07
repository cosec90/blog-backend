package com.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Model.AuthReq;
import com.blog.Model.User;
import com.blog.ServiceImpl.UserImpl;
import com.blog.Utils.JwtUtil;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthorizationController {
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserImpl userImpl;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthReq authReq) throws Exception {
		
		try {
	
			 authManager.authenticate(
					 
					 new UsernamePasswordAuthenticationToken(authReq.getUsername(),authReq.getPassword())
			);
			
		}catch(Exception e) {
			
			throw new Exception("Invalid username and password");
			
		}
	
		return jwtUtil.generateToken(authReq.getUsername());
				 
	}
	
	@PostMapping("/signup")
	public boolean signUp(@RequestBody User user) {
		
		user.setUs_status("ACTIVE");
		userImpl.addUser(user);
		return true;
		
	}
	
	

}
