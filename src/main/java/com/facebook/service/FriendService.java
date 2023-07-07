package com.facebook.service;

import java.util.List;


import com.facebook.model.Friend;
import com.facebook.model.User;

public interface FriendService {
	Friend createRequest(Friend friend);
	List<Friend> getAllFriendRequest();
	Friend getFriendById(Long id);
	
	List<Friend> findFriendsByUserId(Long id);
	
	List<User> getUserByFriendByOrderStatusById(Long id);
}
