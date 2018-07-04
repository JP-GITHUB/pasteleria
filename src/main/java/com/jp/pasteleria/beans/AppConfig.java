package com.jp.pasteleria.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jp.pasteleria.model.User;

@Configuration
public class AppConfig {

	@Bean
	public User dummyUser1() {
		User user1 = new User();
		user1.setNombre("Dummy1");
		user1.setApellido("App Dummy 1");
		user1.setEdad(30);
		
		return user1;		
	}
}
