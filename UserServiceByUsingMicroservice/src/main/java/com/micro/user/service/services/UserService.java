package com.micro.user.service.services;

import java.util.List;

import com.micro.user.service.entities.User;

public interface UserService {
	
	 // 1. create user
	User createUser(User user);
	
	//2. get all user
	List<User> getAllUser();
	
	//3. get single user of given id
	
	User getUserById(String id);
	
	//4.  delete user by id
	
	void deleteUser(String id);
	
	// 5. update User
	
	User updateUser(User user);

}
