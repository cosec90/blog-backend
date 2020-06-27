package com.blog.Model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;



@Entity(name="followers_tb")
@Getter
@Setter
public class Followers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long fl_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="us_id", nullable = false)
	@Basic(fetch=FetchType.LAZY)
	public User user;
	
	public int fl_friendId;
	
	public Followers() {
		
	}

	public Followers(long fl_id, User user, int fl_friendId) {
		super();
		this.fl_id = fl_id;
		this.user = user;
		this.fl_friendId = fl_friendId;
	}
	
	
	
}
