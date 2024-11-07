package com.javaeight.features.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javaeight.features.service.UsersInterface;
import com.javaeight.features.serviceImpl.UsersService;

@Configuration
public class ConfigurationBean {

	 
	@Bean
	 UsersInterface usersInterface() {
		return new UsersService();
	}
}
