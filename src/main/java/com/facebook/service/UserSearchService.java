package com.facebook.service;

import java.util.List;

import com.facebook.model.User;
import com.facebook.model.UserDto;

public interface UserSearchService {
	List<User> getAllUser();
	
	List<UserDto> getAllFriendForUser(Long requestedUserId);

}
