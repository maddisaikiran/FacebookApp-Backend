package com.facebook.service;

import java.util.List;

import com.facebook.model.Comment;

public interface CommentService {
	
	Comment createComment(Comment comment);
	
	void deleteComment(Long commentId);
	
	List <Comment> getCommentsByMessageId(Long timeId);

}
