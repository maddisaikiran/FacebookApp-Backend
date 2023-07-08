package com.facebook.controller;

import java.util.List;

import com.facebook.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.httpresponse.HttpGetStatusResponse;

import com.facebook.httpresponse.HttpStatusResponse;
import com.facebook.model.User;
import com.facebook.model.UserDto;
import com.facebook.service.FriendService;
import com.facebook.service.UserSearchService;
import com.facebook.util.ResponseUtil;

@RestController
@CrossOrigin
public class UserNetworkController {
	@Autowired
	private UserSearchService userSearchService;
	
	@Autowired
	private FriendService service;
	
	@PostMapping("/users/network/")
	public ResponseEntity<HttpStatusResponse> getAllFriendForUser(@RequestBody Long requestedUserId){
		List<UserDto> userDtos = userSearchService.getAllFriendForUser(requestedUserId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), userDtos, Constants.FRIEND_REQUEST_SEND);
		
	}
	
	@GetMapping("/friends/{friendId}")
	public ResponseEntity <HttpGetStatusResponse> getUserByFriendByOrderStatusById(@PathVariable(value = "friendId") Long friendId){
		List<User> users = service.getUserByFriendByOrderStatusById(friendId);
		if(CollectionUtils.isEmpty(users)) {
			return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(),users, Constants.FRIENDS_NOT_FOUND);
		}
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), users,Constants.MY_FRIENDS_FOUND);
	}
}
