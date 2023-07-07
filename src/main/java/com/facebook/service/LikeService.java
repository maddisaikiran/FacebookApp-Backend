package com.facebook.service;

import java.util.List;

import com.facebook.model.Like;

public interface LikeService {
	
	Like createLike(Like like);
	
	List<Like> getUserLikesByMessageById(Integer timeId);
	
}
