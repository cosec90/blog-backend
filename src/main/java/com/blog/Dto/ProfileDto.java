package com.blog.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileDto {

	
	private long pl_id;
	private String pl_name;
	private String pl_surname;
	private String pl_bio;
	private String pl_githubUrl;
	private String pl_instaUrl;
	private String pl_imgUrl;
	
	@Builder
	public ProfileDto(long pl_id, String pl_name, String pl_surname, String pl_bio, String pl_githubUrl,
			String pl_instaUrl, String pl_imgUrl) {
		super();
		this.pl_id = pl_id;
		this.pl_name = pl_name;
		this.pl_surname = pl_surname;
		this.pl_bio = pl_bio;
		this.pl_githubUrl = pl_githubUrl;
		this.pl_instaUrl = pl_instaUrl;
		this.pl_imgUrl = pl_imgUrl;
	}
	
	public ProfileDto() {
		
	}
	
	
}
