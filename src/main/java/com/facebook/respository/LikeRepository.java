package com.facebook.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facebook.model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{
	
@Query(value="select * from User u LEFT JOIN Like l on u.id = l.user.id LEFT JOIN Timeline t on t.id = l.timeline.id where t.id =:timeId", nativeQuery = true)
List <Like> findUserLikesByMessageById(@Param(value = "timeId") Long timeId);

@Query("FROM Like l WHERE l.timeline.id =:timeId")
    List<Like> findLikesByTimelineId(@Param(value = "timeId") Long timeId);
}
