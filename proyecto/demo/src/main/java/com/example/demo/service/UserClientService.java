package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserClient;

public interface UserClientService {
	
	
    UserClient createUser(UserClient user);
	
    
    UserClient saveUser(UserClient user);
	UserClient getUserById(Long id);
	
	List<UserClient> getAllUsers();
	
	UserClient updateUser(UserClient user, Long id);
	
	void deleteUser(Long id);
}
