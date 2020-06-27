package com.blog.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostDto {
	
	private long pt_id;
	private String pt_date;
	private String pt_title;
	private String pt_img;
	
	@Builder
	public PostDto(long pt_id, String pt_post, String pt_date, String pt_title, String pt_img) {
		super();
		this.pt_id = pt_id;
		this.pt_date = pt_date;
		this.pt_title = pt_title;
		this.pt_img = pt_img;
	}
	
	
	

}
