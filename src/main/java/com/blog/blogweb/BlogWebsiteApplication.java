package com.blog.blogweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "com.blog.Model")
@EnableJpaRepositories(basePackages = "com.blog.Dao")
@SpringBootApplication(scanBasePackages = "com.blog.")
public class BlogWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogWebsiteApplication.class, args);
	}

}
