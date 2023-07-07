package com.facebook.service;

import java.util.List;

import com.facebook.model.Timeline;

public interface TimelineService {
	

	Timeline addTimeLine(Timeline timeline,Long userId);
	
	  Timeline getTimelineByTimeId(Long timeId);
	
	  List<Timeline> getAllMyTimeline();
	  
	  List<Timeline> getAllMyTimelineById(Long id);
	  
	  
	  List<Timeline> getUserByFriendByTimelineById(Long userId);

	  void deleteTimeline(Long timeId);
	  
	
}
