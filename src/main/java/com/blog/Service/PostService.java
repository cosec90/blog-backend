package com.blog.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.blog.Dto.PostDto;
import com.blog.Model.Post;

public interface PostService {
	
	boolean createPost(Post post, String token);
	boolean deletePost(int id);
	PostDto postImg(MultipartFile file, String token) throws Exception; 
	List<PostDto> getPost();
	List<PostDto> getPostByUser(int id);
	
	
}
