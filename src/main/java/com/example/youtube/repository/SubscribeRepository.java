package com.example.youtube.repository;

import com.example.youtube.model.Subscribe;
import com.example.youtube.model.TagDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe,Integer> {
    @Query("SELECT s FROM Subscribe s WHERE s.user.id = :userId AND s.userSub.id = :userSubId")
   Subscribe findSubscriptionByUserIdAndUserSubId( int userId,  int userSubId);

}
