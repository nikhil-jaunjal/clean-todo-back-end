package com.example.services;

import com.example.models.UserEntity;

public interface UserService {
	
	Object save(UserEntity userEntity) throws Exception;
	
	Object getAllUsers() throws Exception;
		
}
