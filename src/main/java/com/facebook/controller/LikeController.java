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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.httpresponse.HttpGetStatusResponse;
import com.facebook.httpresponse.HttpStatusResponse;
import com.facebook.model.Like;
import com.facebook.service.LikeService;
import com.facebook.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/like")
public class LikeController {
	
	@Autowired
	LikeService likeService;
	
	@PostMapping
	public ResponseEntity<HttpStatusResponse> createLike(@RequestBody Like like) {
		Like addLike = likeService.createLike(like);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), addLike, Constants.LIKE_ADDED_SUCCESS);
	}
	
	
	@GetMapping("/time/{timeId}")
	public ResponseEntity<HttpGetStatusResponse> getUserLikesByMessageById(@PathVariable(value = "timeId") Long timeId) {
		List<Like> likes = likeService.getUserLikesByMessageById(timeId);
		if(CollectionUtils.isEmpty(likes)) {
			return ResponseUtil.prepareErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.LIKES_NOT_FOUND);
		}
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), likes, Constants.LIKES_FOUND);
	}
	
	
}
