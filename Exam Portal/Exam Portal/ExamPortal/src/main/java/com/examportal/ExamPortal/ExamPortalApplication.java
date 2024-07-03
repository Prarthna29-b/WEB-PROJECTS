package com.examportal.ExamPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
@Configuration
@ComponentScan(basePackages = {"com.examportal.ExamPortal.controller","com.examportal.ExamPorta.config",
		"com.examportal.ExamPortal.service"})
@SpringBootApplication
public class ExamPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}


  }

