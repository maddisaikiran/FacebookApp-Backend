package com.facebook.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.model.Timeline;
import com.facebook.model.User;
import com.facebook.respository.TimelineRepository;
import com.facebook.service.UserService;
import com.facebook.service.TimelineService;

@Service
public class TimelineServiceImpl implements TimelineService{

	@Autowired
	TimelineRepository timelineRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public Timeline addTimeLine(Timeline timeline, Long userId) {
		User user = userService.getUserById(userId);
		
		timeline.setUser(user);
		return timelineRepository.save(timeline);
	}

	@Override
	public List<Timeline> getAllMyTimeline() {
		return timelineRepository.findAll();
	}

	@Override
	public List<Timeline> getAllMyTimelineById(Long id) {
		
		User user = userService.getUserById(id);
		return timelineRepository.findAllByUser(user);	
	}

	@Override
	public List<Timeline> getUserByFriendByTimelineById(Long userId) {
		
		return timelineRepository.findUserByFriendByTimelineById(userId);
		
	}

	@Override
	public Timeline getTimelineByTimeId(Long timeId) {
		return timelineRepository.findById(timeId).get();
	}

	@Override
	public void deleteTimeline(Long timeId) {
		timelineRepository.deleteById(timeId);
	}
}
