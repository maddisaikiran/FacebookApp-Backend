package com.facebook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.model.Comment;
import com.facebook.respository.CommentRepository;
import com.facebook.respository.TimelineRepository;
import com.facebook.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {


	@Autowired
	TimelineRepository timelineRepository;

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Comment createComment(Comment comment) {
		comment.setTimeline(timelineRepository.findById(comment.getTimeline().getId()).get());
		return commentRepository.save(comment);
	}

	@Override
	public void deleteComment(Long commentId) {
		
		commentRepository.deleteById(commentId);
	}

	@Override
	public List<Comment> getCommentsByMessageId(Long timeId) {
		return commentRepository.findCommentsByMessageId(timeId);
	}

}
