package com.facebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.constants.Constants;
import com.facebook.httpresponse.HttpGetStatusResponse;
import com.facebook.httpresponse.HttpStatusResponse;
import com.facebook.model.Friend;
import com.facebook.service.FriendService;
import com.facebook.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/friends")
public class FriendController {
	@Autowired
	private FriendService friendService;
	
	
	@PostMapping("/request")
	public ResponseEntity<HttpStatusResponse> createRequest(@Validated @RequestBody Friend friend) {
		Friend friendObject = friendService.createRequest(friend);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), friendObject,Constants.FRIEND_REQUEST_SEND);
		
	}
	
	
	@GetMapping
	public ResponseEntity<HttpGetStatusResponse> getAllFriendRequest(){
		List<Friend> friends= friendService.getAllFriendRequest();
		if(CollectionUtils.isEmpty(friends)) {
			return ResponseUtil.prepareErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),Constants.FRIENDS_NOT_FOUND);
		}
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), friends, Constants.ALL_FRIENDS_FOUND);
	}

}
