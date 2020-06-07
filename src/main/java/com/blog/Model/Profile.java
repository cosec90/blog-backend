package com.blog.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="profile_tb")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pl_id;
	private String pl_githubUrl;
	private String pl_instaUrl;
	private String pl_imgUrl;
	private String pl_bio;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="us_id", nullable = false)
	public User useProf;

	public long getPl_id() {
		return pl_id;
	}

	public void setPl_id(long pl_id) {
		this.pl_id = pl_id;
	}

	public String getPl_githubUrl() {
		return pl_githubUrl;
	}

	public void setPl_githubUrl(String pl_githubUrl) {
		this.pl_githubUrl = pl_githubUrl;
	}

	public String getPl_instaUrl() {
		return pl_instaUrl;
	}

	public void setPl_instaUrl(String pl_instabUrl) {
		this.pl_instaUrl = pl_instabUrl;
	}

	public String getPl_imgUrl() {
		return pl_imgUrl;
	}

	public void setPl_imgUrl(String pl_imgbUrl) {
		this.pl_imgUrl = pl_imgbUrl;
	}

	public String getPl_bio() {
		return pl_bio;
	}

	public void setPl_bio(String pl_bio) {
		this.pl_bio = pl_bio;
	}

	public User getUseProfr() {
		return useProf;
	}

	public void setUseProfr(User useProfr) {
		this.useProf = useProfr;
	}

	public Profile(long pl_id, String pl_githubUrl, String pl_instaUrl, String pl_imgUrl, String pl_bio,
			User useProf) {
		super();
		this.pl_id = pl_id;
		this.pl_githubUrl = pl_githubUrl;
		this.pl_instaUrl = pl_instaUrl;
		this.pl_imgUrl = pl_imgUrl;
		this.pl_bio = pl_bio;
		this.useProf = useProf;
	}
	public Profile() {
		
	}
}
