package com.blog.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	private long us_id;
	private String us_username;
	private String token;
	
	@Builder
	public UserDto(String us_username, String token, long us_id) {
		super();
		this.us_username = us_username;
		this.token = token;
		this.us_id = us_id;
	}
	

}
