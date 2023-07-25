
package com.example.youtube.Service.video;

import com.example.youtube.model.Video;
import com.example.youtube.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoService {

    private VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

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
        return videoRepository.findById(id);
    }

    public void delete(int id){
        videoRepository.deleteById(id);
    }
    public List<Video> findByTitleContainingOrUsername(String title,String user_username){

        return videoRepository.findByTitleContainingOrUser_Username(title, user_username);
    }

    public List<Video> findVideosByTagId(int id) {
        return videoRepository.findVideosByTagId(id);
    }
    public List<Video> findVideoUserLiked(int id){
        return videoRepository.findLikedVideosByUserId(id);
    }
    public List<Video> findVideosByUserId(int id){
        return videoRepository.findVideosByUserId(id);
    }
}
