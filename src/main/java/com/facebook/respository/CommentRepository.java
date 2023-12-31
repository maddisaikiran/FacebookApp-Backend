package com.facebook.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facebook.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	@Query(value="select c.* from User u LEFT JOIN Comment c on u.id = c.user_id LEFT JOIN Timeline t on t.time_id = c.message_id where t.time_id =:timeId",nativeQuery = true)
       List<Comment> findCommentsByMessageId(@Param(value = "timeId") Long timeId);
}
