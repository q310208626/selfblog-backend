package com.lsj.selfblog.selfblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SelfblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfblogApplication.class, args);
	}

}
