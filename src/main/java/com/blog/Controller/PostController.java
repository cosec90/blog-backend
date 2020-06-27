package com.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blog.Dao.UserDao;
import com.blog.Dto.PostDto;
import com.blog.Model.Post;
import com.blog.ServiceImpl.PostServiceImpl;
import com.blog.ServiceImpl.ProfileServiceImpl;
import com.blog.Utils.JwtUtil;

@RequestMapping("/api") //("/api")
@RestController()
@CrossOrigin(origins = "*")
public class PostController {
	
	@Autowired
	PostServiceImpl postServiceImpl;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/addPost")
	public boolean addPost(@RequestBody Post post,@RequestHeader(value = "Authorization")String token) {
		
		postServiceImpl.createPost(post,token);
		
		return true;
	}
	
	@PostMapping("/addPostImg")
	public PostDto addPostImg(@RequestParam("file")MultipartFile file,@RequestHeader(value = "Authorization")String token) throws Exception{
		
		PostDto postDto = postServiceImpl.postImg(file,token);
		
		return postDto;
		
	}
	
	@GetMapping("/deletePost/{id}")
	public Integer deletePost(@PathVariable("id")int id) {
		
		return id;
	}
	
	@GetMapping("/getPost")
	public List<PostDto> getPost(){
		
		List<PostDto> postList = postServiceImpl.getPost();
		return postList;
		
	}
	
	
	

}
