package com.facebook.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facebook.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long>{

	@Query(value="select m from Message m LEFT JOIN User u on u.id = m.user.id where m.friend.id = (:friendId)")
	List<Message> findMessagesByFriendId(@Param(value="friendId")Long friendId);
	
	@Query(value="select m from Message m LEFT JOIN User u on u.id = m.user.id where m.user.id = (:userId)")
	List<Message> findMessagesByUserId(@Param(value="userId")Long userId);
}
