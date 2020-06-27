package com.blog.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;


@Entity(name="post_tb")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long pt_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="us_id", nullable = false)
	public User userPost;
	
	public String pt_date;
	public String pt_title;
	public String pt_post;
	public String pt_img;
	
	
	public String getPt_img() {
		return pt_img;
	}

	public void setPt_img(String pt_img) {
		this.pt_img = pt_img;
	}

	public long getPt_id() {
		return pt_id;
	}

	public void setPt_id(long pt_id) {
		this.pt_id = pt_id;
	}

	public User getUserPost() {
		return userPost;
	}

	public void setUserPost(User userPost) {
		this.userPost = userPost;
	}

	public String getPt_date() {
		return pt_date;
	}

	public void setPt_date(String pt_date) {
		this.pt_date = pt_date;
	}

	public String getPt_title() {
		return pt_title;
	}

	public void setPt_title(String pt_title) {
		this.pt_title = pt_title;
	}

	public String getPt_post() {
		return pt_post;
	}

	public void setPt_post(String pt_post) {
		this.pt_post = pt_post;
	}

	public Post() {
		
	}

	public Post(long pt_id, User userPost, String pt_date, String pt_title, String pt_post, String pt_img) {
		super();
		this.pt_id = pt_id;
		this.userPost = userPost;
		this.pt_date = pt_date;
		this.pt_title = pt_title;
		this.pt_post = pt_post;
		this.pt_img = pt_img;
	}

	

}
