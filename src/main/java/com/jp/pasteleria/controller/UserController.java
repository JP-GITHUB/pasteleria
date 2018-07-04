package com.jp.pasteleria.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.pasteleria.beans.AppConfig;
import com.jp.pasteleria.exception.ResourceNotFoundException;
import com.jp.pasteleria.model.User;
import com.jp.pasteleria.pasteleria.PasteleriaApplication;
import com.jp.pasteleria.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(PasteleriaApplication.class);
		
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/dummy1")
	public List<User> getDummy1() throws JsonProcessingException {
		List<User> tmpList = new ArrayList<User>();
		ObjectMapper mapper = new ObjectMapper();
		
		@SuppressWarnings("resource")
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		User userDummy1 = (User) appContext.getBean("dummyUser1");
		
		String jsonInString = mapper.writeValueAsString(userDummy1);		
		logger.info("Test cast object");
		logger.info(jsonInString);
		
		tmpList.add(userDummy1);
		return tmpList;
	}
	
	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		
	    return userRepository.save(user);
	}
	
	@PutMapping("/users/{id}")
	public User updateNote(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {

		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		user.setNombre(userDetails.getNombre());
		user.setApellido(userDetails.getApellido());
		user.setEdad(userDetails.getEdad());
		user.setEmail(userDetails.getEmail());

	    User updatedUser = userRepository.save(user);
	    return updatedUser;
	}
}