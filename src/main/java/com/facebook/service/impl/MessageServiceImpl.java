package com.facebook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facebook.model.Message;
import com.facebook.respository.MessageRepository;
import com.facebook.respository.UserRespository;
import com.facebook.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public Message createMessage(Message message) {

		message.setFriend(userRespository.findById(message.getFriend().getId()).get());
		
		return messageRepository.save(message);
	}

	@Override
	public List<Message> getMessagesByFriendId(Integer friendId) {

		return messageRepository.findMessagesByFriendId(friendId);
			
	}

	@Override
	public List<Message> getMessagesByUserId(Integer userId) {
		
	return messageRepository.findMessagesByUserId(userId);		
	}

}
