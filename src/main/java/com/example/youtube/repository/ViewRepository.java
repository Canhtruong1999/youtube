package com.example.youtube.repository;

import com.example.youtube.model.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends JpaRepository<View,Integer> {
    int countByVideoId(int videoId);
}
