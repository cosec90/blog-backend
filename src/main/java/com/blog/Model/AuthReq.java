package com.blog.Model;

public class AuthReq {
	
	public String username;
	public String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthReq(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public AuthReq() {
		
	}

}
