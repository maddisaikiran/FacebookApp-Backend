package com.facebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.model.User;
import com.facebook.respository.UserRespository;
import com.facebook.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	

	@Autowired
	private UserRespository userRespository;
	
	
	@Override
	public User addUser(User user)  {
		return userRespository.save(user);
	}

	@Override
	public User updateUser(User user){
		return userRespository.save(user);
	}

	@Override
	public void deleteUser(Long id) {

		userRespository.deleteById(id);
	}

//	@Override
//	public User findByUserEmail(String email) {
//
//		return userRespository.findByEmail(email);
//
//	}

	@Override
	public User getUserById(Long id){
		return userRespository.findById(id).get();
		
		
	}

	@Override
	public User getUserByEmailAndPassword(String emailId, String password) {
		return userRespository.findByEmailIdAndPassword(emailId, password);
	}

	@Override	
	public User updateUserStatus(Long id,boolean userStatus) {
		
		
		User user = userRespository.findById(id).get();
	     user.setUserStatus(userStatus);
		return userRespository.save(user);
	}

	

}
