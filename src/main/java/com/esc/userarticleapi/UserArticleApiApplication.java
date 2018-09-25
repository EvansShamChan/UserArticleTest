package com.esc.userarticleapi;

import com.esc.userarticleapi.service.ArticleService;
import com.esc.userarticleapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class UserArticleApiApplication {

	@Autowired
	private UserService userService;

	@Autowired
	private ArticleService articleService;

	@EventListener(ApplicationReadyEvent.class)
	public void fillUpDb() {
		userService.fillUpUserTable();
		articleService.fillUpArticleTable();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserArticleApiApplication.class, args);
	}
}
