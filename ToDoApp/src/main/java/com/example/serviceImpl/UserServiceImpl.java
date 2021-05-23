package com.example.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.UserEntity;
import com.example.repositories.UserRepository;
import com.example.services.UserService;
import com.example.config.CustomDozerHelper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	private Mapper mapper = new DozerBeanMapper();

	@Override
	public Object getAllUsers() throws Exception {
		Map<String, Object> data = new HashMap<>();		
		try {			
			List<UserEntity> userList =  (List<UserEntity>) userRepository.findAll();
			data.put("userList",CustomDozerHelper.map(mapper, userList, UserEntity.class));
		} catch (Exception e) {	
			e.printStackTrace();
			data.put("error", e.getMessage());
		}
		return data;
	}

	@Override
	public Object save(UserEntity userEntity) throws Exception {		
		Map<String, Object> data = new HashMap<>();		
		try {						
			data.put("success", userRepository.save(userEntity));
		} catch (Exception e) {	
			e.printStackTrace();
			data.put("error", e.getMessage());
		}
		return data;
	}

}
