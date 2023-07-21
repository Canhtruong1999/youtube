package com.example.youtube.service;

import com.example.youtube.model.Video;
import com.example.youtube.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    public List<Video> findAll(){
        return videoRepository.findAll();
    }
    public void createVideo(Video video){
        videoRepository.save(video);
    }

    public Video create(Video video){

        return videoRepository.save(video);
    }

    public void update(Video video){
        videoRepository.save(video);
    }

    public Video findById(int id){
        return videoRepository.findById(id).get();
    }

    public void delete(int id){
        videoRepository.deleteById(id);
    }
    public List<Video> findByTitleContainingOrUsername(String title,String user_username){

        return videoRepository.findByTitleContainingOrUser_Username(title, user_username);
    }

}