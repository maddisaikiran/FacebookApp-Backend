package com.facebook.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.model.Like;
import com.facebook.respository.LikeRepository;
import com.facebook.respository.TimelineRepository;
import com.facebook.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeRepository likeRepository ;
	
	@Autowired
	TimelineRepository timelineRepository;

	@Override
	public Like createLike(Like like) {
		like.setTimeline(timelineRepository.findById(like.getTimeline().getId()).get());
		return likeRepository.save(like);
	}

	@Override
	public List<Like> getUserLikesByMessageById(Long timeId) {
		List<Like> likes = likeRepository.findLikesByTimelineId(timeId);
		if(CollectionUtils.isNotEmpty(likes)) {
			return likeRepository.findUserLikesByMessageById(timeId);
		}
		return likes;
	}
}
