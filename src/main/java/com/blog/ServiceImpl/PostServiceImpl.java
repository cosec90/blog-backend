package com.blog.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.Dao.PostDao;
import com.blog.Dao.UserDao;
import com.blog.Dto.PostDto;
import com.blog.Model.Post;
import com.blog.Model.User;
import com.blog.Service.PostService;
import com.blog.Utils.JwtUtil;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	PostDao postDao;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private org.springframework.core.env.Environment env;

	@Override
	public boolean createPost(Post post,String token) {
		
		String username = jwtUtil.extractUsername(token.substring(7));
		User user = userDao.findByUsername(username);
		post.setUserPost(user);
		postDao.save(post);
		return true;
	}

	@Override
	public boolean deletePost(int pt_id) {
		
		Post post = postDao.getPostById(pt_id);
		postDao.delete(post);
		
		return true;
	}

	@Override
	public PostDto postImg(MultipartFile file, String token) throws Exception {
		
		String username = jwtUtil.extractUsername(token.substring(7));
		String user_id = userDao.getUserId(username).toString();
		
		String path ="D:\\blog-images\\";
		String user_path = path + user_id;
		String new_path = "";
		
		new_path = user_path+"\\"+file.getOriginalFilename();
		
		
		try {
			
			byte[] bytes= file.getBytes();
			Path path1= Paths.get(new_path);
			Files.write(path1, bytes);
		
		}catch(IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
			return getImg(new_path);
		}
	

	@Override
	public List<PostDto> getPost() {
		
		
		List<PostDto> postList = new ArrayList<PostDto>();
		List<Post> posts = postDao.findAll();
		for(Post post:posts) {
			postList.add(getPost(post));
		}
		
		return postList;
	}

	@Override
	public List<PostDto> getPostByUser(int id) {
		
		List<Post> posts = postDao.getPostByUser(id);
		List<PostDto> postList = new ArrayList<PostDto>();
		for(Post post:posts) {
			postList.add(getPost(post));
		}
		return postList;
	}
	
	

	@SuppressWarnings("img")
	public PostDto getImg(String path) {
		
		return PostDto.builder().pt_img(path).build();
	}
	
	@SuppressWarnings("post")
	public PostDto getPost(Post entity) {
		
		return PostDto.builder().pt_date(entity.pt_date).pt_id(entity.pt_id).pt_title(entity.pt_title).build();
	}

}
