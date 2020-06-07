package com.blog.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity(name="following_tb")
public class Followers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long fl_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="us_id", nullable = false)
	public User user;
	
	public int fl_followers;

	public long getFl_id() {
		return fl_id;
	}

	public void setFl_id(long fl_id) {
		this.fl_id = fl_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getFl_followers() {
		return fl_followers;
	}

	public void setFl_followers(int fl_followers) {
		this.fl_followers = fl_followers;
	}

	public Followers(long fl_id, User user, int fl_followers) {
		super();
		this.fl_id = fl_id;
		this.user = user;
		this.fl_followers = fl_followers;
	}
	public Followers() {
		
	}
	
	
}
