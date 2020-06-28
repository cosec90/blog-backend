package com.blog.ServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.Dao.ProfileDao;
import com.blog.Dao.UserDao;
import com.blog.Dto.ProfileDto;
import com.blog.Model.Profile;
import com.blog.Model.User;
import com.blog.Service.ProfileService;
import com.blog.Utils.JwtUtil;

@Service
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileDao profileDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private org.springframework.core.env.Environment env;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	

	@Override
	public boolean addProfileInfo(Profile profile, String username) {
		
		User user = userDao.findByUsername(username);
		profile.setUseProf(user);
		profileDao.save(profile);
		return true;
	}

	public List<Profile> getProfiles(){
		
		
		return profileDao.findAll();
	}

	@Override
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile findById(int id) {
		
		return profileDao.findById(id);
	}

	@Override
	public ProfileDto uploadImg(MultipartFile file,String token) throws Exception{
		
		String username = jwtUtil.extractUsername(token.substring(7));
		String user_id = userDao.getUserId(username).toString();
		String path ="D:\\blog-images\\";
		String user_path = path + user_id;
		
		System.out.println(user_path);
		String new_path = "";
		File directory =new File(user_path);
		directory.mkdir();
		
		new_path = user_path+"\\"+file.getOriginalFilename();
		
		File dir = new File(new_path);
		
		if(Files.exists(dir.toPath())) {
			throw new Exception("File exists. Please rename the file");
		}
		
		try {
			
				byte[] bytes= file.getBytes();
				Path path1= Paths.get(new_path);
				Files.write(path1, bytes);
			
		}catch(IllegalStateException | IOException e) {
			
		}
		
		return getImgUrl(new_path);
		
	}

	@Override
	public boolean updateProfile(Profile profile, int id, String token) {
		
		
		String username = jwtUtil.extractUsername(token.substring(7));
		User user = userDao.findByUsername(username);
		profile.setUseProf(user);
		profileDao.save(profile);
		
//		profileDao.save(profile);
		
		return true;
		
	}

	@Override
	public boolean updateProfileImg(MultipartFile file, long pl_id) {
		
		String old_path = profileDao.getImg(pl_id);
		
		File old_file = new File(old_path);
		
		old_file.delete();
		
		String new_path ="D:\\blog-images\\"+pl_id+"\\"+file.getOriginalFilename();
		
		profileDao.updateProfileImg(new_path, pl_id);
		
		return true;
	}

	@SuppressWarnings("unused")
	public ProfileDto getProfileDto(Profile entity) {
		
		
		return ProfileDto.builder().pl_bio(entity.getPl_bio()).pl_githubUrl(entity.getPl_githubUrl())
				.pl_instaUrl(entity.getPl_instaUrl()).pl_name(entity.getPl_name()).pl_surname(entity.getPl_surname())
				.pl_imgUrl(entity.getPl_imgUrl()).build();
	}
	
	
	@SuppressWarnings("user")
	public ProfileDto getImgUrl(String path) {
		
		
		return ProfileDto.builder().pl_imgUrl(path).build();
		
	}
	
	
	
}
