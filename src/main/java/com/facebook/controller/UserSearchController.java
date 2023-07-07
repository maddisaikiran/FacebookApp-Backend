package com.facebook.controller;

import java.util.List;

import com.facebook.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.httpresponse.HttpGetStatusResponse;
import com.facebook.model.User;
import com.facebook.service.UserSearchService;
import com.facebook.util.ResponseUtil;


@RestController
@CrossOrigin
public class UserSearchController {
	@Autowired
	private UserSearchService userSearchService;
	
	@GetMapping("/users")
	public ResponseEntity<HttpGetStatusResponse> getAllUser(){
		List<User> users = userSearchService.getAllUser();
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(),users, Constants.USER_DATA_RETRIVAL);
		
	}
	
}
