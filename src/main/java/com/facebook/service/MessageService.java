package com.facebook.service;

import java.util.List;

import com.facebook.model.Message;

public interface MessageService {

	Message createMessage(Message message);
	
	List<Message> getMessagesByFriendId(Long friendId);
	
	List<Message> getMessagesByUserId(Long userId);
}
