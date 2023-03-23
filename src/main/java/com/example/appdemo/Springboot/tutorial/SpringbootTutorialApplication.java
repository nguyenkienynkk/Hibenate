package com.example.appdemo.Springboot.tutorial;

import Emtity.root;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

@RequiredArgsConstructor
@EnableJpaAuditing
public class SpringbootTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTutorialApplication.class, args);
	}
	@PostConstruct
	void kiemtra(){
		for (int i = 1; i < 10; i++) {
			root roots = new root();
			roots.setId(Long.valueOf("Id : "+i));
			roots.setPassword("Password:"+i);
			roots.setFullname("Fullname :"+i);
			roots.setUsername("Usersname :"+i);
//			users.setCreateDate();
//			users.setModifiedAt();
		}
	}


}
