package com.blog.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.Model.Followers;


@Repository
public interface FollowersDao extends JpaRepository<Followers, Long>{
	
	@Query(value= "SELECT * from followers_tb where us_id = ?1", nativeQuery = true)
	List<Followers> getUserFollower(int id);
	

}
