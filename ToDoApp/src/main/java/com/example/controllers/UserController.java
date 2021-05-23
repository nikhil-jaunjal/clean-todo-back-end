package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.UserEntity;
import com.example.serviceImpl.UserServiceImpl;

@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
	public Object getAllUsers() throws Exception {
		return userServiceImpl.getAllUsers();
	}
	
	@PostMapping
	public Object save(@RequestBody UserEntity userEntity) throws Exception {
		return userServiceImpl.save(userEntity);
	}
	
}
