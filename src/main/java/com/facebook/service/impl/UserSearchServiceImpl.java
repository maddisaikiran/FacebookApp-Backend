package com.facebook.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.model.Friend;
import com.facebook.model.User;
import com.facebook.model.UserDto;
import com.facebook.respository.UserRespository;
import com.facebook.service.UserSearchService;

@Service
public class UserSearchServiceImpl implements UserSearchService{

	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private FriendServiceImpl friendServiceImpl;

	@Override
	public List<User> getAllUser() {
		return userRespository.findAll();
	}

	
	@Override
	public List<UserDto> getAllFriendForUser(Long requestedUserId) {
		List<User> users= userRespository.findAll();
		List<Friend> friends= friendServiceImpl.findFriendsByUserId(requestedUserId);
		users = users.stream().filter(user -> user.getId() != requestedUserId).collect(Collectors.toList());
		for(User user:users) {
			Optional<Friend> friendOptional=friends.stream().filter(friend -> friend.getUser().getId() == user.getId() || friend.getFriend().getId()==user.getId()).findFirst();
			List<Friend> friendsFinal = new ArrayList<>();
			if(friendOptional.isPresent()) {
				friendsFinal.add(friendOptional.get());
				user.setFriend(friendsFinal);
			}
		}
		
		return users.stream().map(user-> UserDto.convert(user)).collect(Collectors.toList());
		
	}
}
