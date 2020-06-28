package com.blog.Dao;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.Model.Profile;

@Repository
public interface ProfileDao extends JpaRepository<Profile, Long>{
	
	@Query(value= "SELECT * from profile_tb where pl_id = ?1", nativeQuery = true)
	Profile findById(int id);
	
	@Modifying
	@Transactional
	@Query(value= "Update profile_tb set pl_imgUrl= :path where pl_id = :id")
	Integer updateProfileImg(@Param("path")String path,@Param("id") Long id);
	
	
	@Query(value= "Select pl_imgUrl from profile_tb where pl_id = ?1", nativeQuery = true)
	String getImg(long pl_id);

}
