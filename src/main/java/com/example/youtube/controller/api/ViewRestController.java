package com.example.youtube.controller.api;
import com.example.youtube.Service.video.VideoService;
import com.example.youtube.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ViewRestController {

    private final VideoService videoService;


    public ViewRestController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/api/view")
    public ResponseEntity<Integer> getViewCount(@RequestParam int videoId) {
        int viewCount = videoService.getViewCountByVideoId(videoId);
        return new ResponseEntity<>(viewCount, HttpStatus.OK);
    }
}