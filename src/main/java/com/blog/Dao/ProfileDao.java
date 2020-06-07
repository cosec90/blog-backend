package com.blog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.Model.Profile;

@Repository
public interface ProfileDao extends JpaRepository<Profile, Long>{
	
	@Query(value= "SELECT * from profile_tb where pl_id = ?1", nativeQuery = true)
	Profile findById(int id);

}
