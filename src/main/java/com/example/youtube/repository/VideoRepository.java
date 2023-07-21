package com.example.youtube.repository;

import com.example.youtube.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {

    Page<Video> findByTitleContainingOrUser_Username(String title, String user_username, Pageable pageable);
    @Query(value = "SELECT v FROM Video v " +
            "JOIN User u ON v.user.id = u.id " +
            "WHERE v.title LIKE %:title% OR u.username LIKE %:username%")
    List<Video> findByTitleContainingOrUser_Username(String title, String username);
}
