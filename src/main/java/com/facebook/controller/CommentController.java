package com.facebook.controller;

import java.util.List;

import com.facebook.util.ResponseUtil;
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

import com.facebook.constants.Constants;
import com.facebook.httpresponse.HttpGetStatusResponse;
import com.facebook.httpresponse.HttpStatusResponse;
import com.facebook.model.Comment;
import com.facebook.service.CommentService;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping
	public ResponseEntity<HttpStatusResponse> createComment(@Validated @RequestBody  Comment comment) {
		Comment addComment = commentService.createComment(comment);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), addComment, Constants.COMMENT_ADDED_SUCCESS);
		
	}
	@DeleteMapping("/{commentId}")
	public ResponseEntity<HttpStatusResponse> deleteComment(@PathVariable Long commentId) {
		commentService.deleteComment(commentId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.NO_CONTENT.value(), commentId, Constants.COMMENT_DELETE_SUCCESS);
	}
	
	
	
	@GetMapping("/time/{timeId}")
	public ResponseEntity<HttpGetStatusResponse> getCommentsByMessageId(@PathVariable(value = "timeId") Long timeId){
		List<Comment> comments = commentService.getCommentsByMessageId(timeId);
		if(CollectionUtils.isEmpty(comments)) {
			return ResponseUtil.prepareErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.COMMENTS_NOT_FOUND);
		}
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), comments, Constants.COMMENTS_FOUND);
	}
}
