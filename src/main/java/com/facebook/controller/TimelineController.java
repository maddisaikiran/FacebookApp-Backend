package com.facebook.controller;

import java.util.List;

import com.facebook.constants.Constants;
import com.facebook.constants.UrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.httpresponse.HttpGetStatusResponse;
import com.facebook.httpresponse.HttpStatusResponse;
import com.facebook.model.Timeline;

import com.facebook.service.TimelineService;
import com.facebook.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/timeline")
public class TimelineController {

	
	@Autowired
	TimelineService timelineService;
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<HttpStatusResponse> addTimeLine(@Validated @RequestBody Timeline timeline, @PathVariable Long userId) {
		Timeline addTimeline = timelineService.addTimeLine(timeline, userId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), addTimeline, Constants.TIMELINE_ADDED_SUCCESS);
	}
	
	@GetMapping
	public ResponseEntity<HttpGetStatusResponse> getAllMyTimeline() {
		List<Timeline> timelines = timelineService.getAllMyTimeline();
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), timelines, Constants.ALL_TIMELINE_FOUND);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity <HttpGetStatusResponse> getAllMyTimelineById(@PathVariable Long id){
	List<Timeline> timelines = timelineService.getAllMyTimelineById(id);
	if(CollectionUtils.isEmpty(timelines)) {
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(),timelines, Constants.TIMELINES_NOT_FOUND);
	}
	return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), timelines,Constants.MY_TIMELINE_FOUND );
	}

	@GetMapping("/friend/{userId}")
	public ResponseEntity <HttpGetStatusResponse> getUserByFriendByTimelineById(@PathVariable(value = "userId") Long userId){
        List<Timeline> timelines = timelineService.getUserByFriendByTimelineById(userId);
        if(CollectionUtils.isEmpty(timelines)) {
    		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(),timelines, Constants.TIMELINES_NOT_FOUND);
    	}
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(),timelines,Constants.ALL_TIMELINE_FOUND);
}
	
	@GetMapping(UrlConstants.GET_TIMEID)
	public ResponseEntity<HttpStatusResponse>  getTimelineByTimeId(@PathVariable Long timeId) {
		Timeline timeline = timelineService.getTimelineByTimeId(timeId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.OK.value(), timeline, Constants.ALL_TIMELINE_FOUND);
	
	}
	
	@DeleteMapping(UrlConstants.GET_TIMEID)
	public ResponseEntity<HttpStatusResponse> deleteTimeline(@PathVariable Long timeId) {
		timelineService.deleteTimeline(timeId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.NO_CONTENT.value(), timeId, Constants.TIMELINE_DELETE_SUCCESS);
	}
	
}
