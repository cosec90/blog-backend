package com.blog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.Model.Followers;


@Repository
public interface FollowersDao extends JpaRepository<Followers, Long>{
	
	

}
