package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserClient;
import com.example.demo.repository.UserClientRepository;
import com.example.demo.service.UserClientService;

@Service
public class UserClientImpl implements UserClientService {
    
	@Autowired
	UserClientRepository  userRepository;
	
	
	@Override
	public UserClient createUser(UserClient user) {
		return saveUser(user);
	}

	
	@Override
	public UserClient saveUser(UserClient user) {
		return userRepository.save(user);
	}
	
	
	@Override
	public UserClient getUserById(Long id) {
		return userRepository.findById(id)
			.orElseThrow( ()-> new IllegalStateException("User does not exist with id "+ id) );
	}

	@Override
	public List<UserClient> getAllUsers() {
		
		return (List<UserClient>) userRepository.findAll();
	}



	@Override
	public UserClient updateUser(UserClient user, Long id) {

		
	  UserClient existingUser= getUserById(id);
		existingUser.setName( user.getName() );
		existingUser.setPhone(user.getPhone());
		existingUser.setEmail( user.getEmail());
		existingUser.setPassword( user.getPassword());
		
	
		return saveUser(existingUser);
	}

	@Override
	public void deleteUser(Long id) {

		UserClient existingUser = userRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("User does not exist with id "+ id) );
		userRepository.delete(existingUser);
	}

	

}
