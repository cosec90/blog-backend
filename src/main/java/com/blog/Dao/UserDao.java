package com.blog.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.blog.Model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	
	@Query(value= "SELECT us_id from user_tb where us_username = ?1", nativeQuery = true)
	Integer getUserId(String us_username);
	
	@Query(value= "SELECT * from user_tb where us_username = ?1", nativeQuery = true)
	User findByUsername(String us_username);
	
	
}
