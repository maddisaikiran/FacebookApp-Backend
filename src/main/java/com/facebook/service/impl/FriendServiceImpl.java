package com.facebook.service.impl;

import com.facebook.model.Friend;
import com.facebook.model.FriendStatus;
import com.facebook.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.respository.FriendRepository;
import com.facebook.respository.FriendStatusRepository;
import com.facebook.respository.UserRespository;
import com.facebook.service.FriendService;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService{

	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private FriendStatusRepository friendStatusRepository;
	
	@Autowired
	private UserRespository userRespository;
	
	@Override
	public Friend createRequest(Friend friend) {

		FriendStatus friendStatus= friendStatusRepository.findByStatus(friend.getStatusCode());
		friend.setStatus(friendStatus);
		friend.setFriend(userRespository.findById(friend.getFriend().getId()).get());
		return friendRepository.save(friend);
	}

	@Override
	public List<Friend> getAllFriendRequest() {

		return friendRepository.findAll();
	}

	@Override
	public Friend getFriendById(Long id) {

	return friendRepository.findById(id).get();
		
	}
	
		@Override
	public List<Friend> findFriendsByUserId(Long id) {

		return friendRepository.findFriendsByUserId(id);
	}

	@Override
	public List<User> getUserByFriendByOrderStatusById(Long id) {
		return userRespository.findUserByFriendByOrderStatusById(id);
		
	}
}
