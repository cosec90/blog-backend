package com.blog.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Getter;
import lombok.Setter;


@Entity(name = "user_tb")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long us_id;
	@Column(name="us_username")
	private String us_username;
	
	@Column(name="us_password")
	public String us_password;
	
	@Column(name="us_email")
	public String us_email;
	
	
	@Column(name="us_status")
	public String us_status;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy = "user")
	private List<Followers> followers;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy = "useProf", optional = false)
	@LazyToOne(value = LazyToOneOption.NO_PROXY)
	private Profile profile;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy = "userPost")
	private List<Post> post;
	
	
	public long getUs_id() {
		return us_id;
	}

	public void setUs_id(long us_id) {
		this.us_id = us_id;
	}

	public String getUs_username() {
		return us_username;
	}

	public void setUs_username(String us_username) {
		this.us_username = us_username;
	}

	public String getUs_password() {
		return us_password;
	}

	public void setUs_password(String us_password) {
		this.us_password = us_password;
	}

	public String getUs_email() {
		return us_email;
	}

	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}

	public String getUs_status() {
		return us_status;
	}

	public void setUs_status(String us_status) {
		this.us_status = us_status;
	}

	public List<Followers> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Followers> followers) {
		this.followers = followers;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public User() {
		
	}

	public User(long us_id, String us_username, String us_password, String us_email, String us_status,
			List<Followers> followers, Profile profile, List<Post> post) {
		super();
		this.us_id = us_id;
		this.us_username = us_username;
		this.us_password = us_password;
		this.us_email = us_email;
		this.us_status = us_status;
		this.followers = followers;
		this.profile = profile;
		this.post = post;
	}
	
}
