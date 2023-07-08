package com.facebook.respository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.facebook.model.FriendStatus;

@Repository
public interface FriendStatusRepository extends JpaRepository<FriendStatus, Integer>{

	@Query("select fs from FriendStatus fs where fs.name=(:statusCode)")
	FriendStatus findByStatus(String statusCode);

}
