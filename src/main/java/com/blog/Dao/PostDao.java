package com.blog.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.blog.Model.Post;

public interface PostDao extends JpaRepository<Post, Long>{
	
	
	@Query(value= "SELECT * from post_tb where us_id = ?1", nativeQuery = true)
	List<Post> getPostByUser(int id);
	
	@Query(value= "SELECT * from post_tb where pt_id = ?1", nativeQuery = true)
	Post getPostById(int pt_id);

}
