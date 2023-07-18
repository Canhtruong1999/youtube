package com.example.youtube.repository;

import com.example.youtube.model.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {
Page<Video> findByTitleContainingOrUser_Username(String title, String user_username, Pageable pageable);
}
