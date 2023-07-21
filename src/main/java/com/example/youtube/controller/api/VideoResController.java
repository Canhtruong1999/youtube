package com.example.youtube.controller.api;

import com.example.youtube.Service.user.AuthService;
import com.example.youtube.model.User;
import com.example.youtube.model.Video;
import com.example.youtube.repository.VideoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
public class VideoResController {
    private final VideoRepository videoRepository;
    public final AuthService authService;

    public VideoResController(VideoRepository videoRepository, AuthService authService) {
        this.videoRepository = videoRepository;
        this.authService = authService;
    }


    @GetMapping
     public List<Video> showSearch() {
        List<Video> videos=new ArrayList<>();
        try{
            User user=  authService.findByName(authService.getCurrentUser());
            List<Object[]> a= videoRepository.findTopTwoTagsByUserId(user.getId());
            List<Integer> b= videoRepository.findVideoIdsByTagTitle((String) a.get(0)[0], (String) a.get(1)[0]);
            for (var item:b) {
                videos.add(videoRepository.findById(item.intValue()));
            }
            return videos;
        }catch (Exception e){
            return videoRepository.findAll();
        }

}
}
