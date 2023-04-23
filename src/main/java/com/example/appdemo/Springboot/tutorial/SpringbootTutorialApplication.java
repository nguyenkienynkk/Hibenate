package com.example.appdemo.Springboot.tutorial;

import com.example.appdemo.Springboot.tutorial.Entity.Person;
import com.example.appdemo.Springboot.tutorial.Repository.Repo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaAuditing
public class SpringbootTutorialApplication {
	private final Repo repo;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootTutorialApplication.class, args);

	}
}
