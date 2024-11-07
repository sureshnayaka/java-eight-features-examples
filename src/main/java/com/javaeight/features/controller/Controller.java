package com.javaeight.features.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaeight.features.model.Users;
import com.javaeight.features.service.UsersInterface;

@RestController
@RequestMapping("/java-eight/api/v1/")
public class Controller {
	
	@Autowired
	UsersInterface usersInterface;
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return usersInterface.getAllusers();		
	}

}
