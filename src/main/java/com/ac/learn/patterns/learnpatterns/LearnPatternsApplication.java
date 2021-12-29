package com.ac.learn.patterns.learnpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LearnPatternsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnPatternsApplication.class, args);
	}

}
