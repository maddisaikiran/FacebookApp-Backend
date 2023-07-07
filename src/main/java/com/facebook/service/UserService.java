package com.facebook.service;

import com.facebook.model.User;

public interface UserService {
	User addUser(User user) ;
	User updateUser(User user) ;
	void deleteUser(Long id);
	User getUserByEmailAndPassword(String emailId, String password);
//	User findByUserEmail(String email);
	User getUserById(Long id);
	User updateUserStatus(Long id,boolean userStatus);
	

}
