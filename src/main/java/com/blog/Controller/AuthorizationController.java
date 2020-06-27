package com.blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.Dto.UserDto;
import com.blog.Model.AuthReq;
import com.blog.Model.User;
import com.blog.Service.CustomUserDetailService;
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
	
	@Autowired
	private CustomUserDetailService userDetailService;
	
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
	
	@PostMapping("/login")
	public ResponseEntity<UserDto> login(@RequestBody AuthReq authReq) {
		
		UserDetails userDetails = userDetailService.loadUserByUsername(authReq.getUsername());
		String jwt = jwtUtil.generateToken(authReq.getUsername());
		UserDto user = userImpl.getUserByUsername(authReq.getUsername());
		user.setToken(jwt);
		return ResponseEntity.ok(user);
	
	}
}
