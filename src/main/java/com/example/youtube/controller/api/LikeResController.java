<<<<<<< HEAD
package com.example.youtube.controller.api;
import com.example.youtube.Service.AuthService;
import com.example.youtube.Service.like.LikeService;
import com.example.youtube.Service.video.VideoService;
import com.example.youtube.model.Likes;
import com.example.youtube.model.User;
import com.example.youtube.model.Video;
import com.example.youtube.repository.VideoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeResController {
    private final LikeService likeService;
    private final VideoService videoService;
    private final AuthService authService;
    private final VideoRepository videoRepository;

    public LikeResController(LikeService likeService, VideoService videoService, AuthService authService, VideoRepository videoRepository) {
        this.likeService = likeService;
        this.videoService = videoService;

        this.authService = authService;
        this.videoRepository = videoRepository;
    }

    @PostMapping ("/create")
    public void create(@RequestBody Likes request){

            User user=  authService.findByName(authService.getCurrentUser());
            if(user==null){
                return;
            }else {
                Video video =request.getVideo();
               Likes likes= likeService.findByUserAndVideo(user,video);
               if(likes==null){
                   likeService.create(new Likes(request.getLikeStatus(),user,video));
               }else if(likes.getLikeStatus()==request.getLikeStatus()){
                   likeService.deleteLike(likes);
               }else {
                   likes.setLikeStatus(request.getLikeStatus());
                   likeService.create(likes);
               }
            }

    }

    @PostMapping ("/getLike")
    public ResponseEntity<?> getLike(@RequestBody Likes request){

        User user=  authService.findByName(authService.getCurrentUser());
        if(user==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("login first");
        }else {
            Video video =request.getVideo();
            Likes likes= likeService.findByUserAndVideo(user,video);
            return ResponseEntity.ok(likes);
        }




    }
}
=======
package com.example.youtube.controller.api;

import com.example.youtube.Service.AuthService;
import com.example.youtube.Service.like.LikeService;

import com.example.youtube.Service.video.VideoService;

import com.example.youtube.model.Likes;
import com.example.youtube.model.User;
import com.example.youtube.model.Video;
import com.example.youtube.repository.VideoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/likes")
public class LikeResController {
    private final LikeService likeService;
    private final VideoService videoService;
    private final AuthService authService;
    private final VideoRepository videoRepository;

    public LikeResController(LikeService likeService, VideoService videoService, AuthService authService, VideoRepository videoRepository) {
        this.likeService = likeService;
        this.videoService = videoService;

        this.authService = authService;
        this.videoRepository = videoRepository;
    }

    @PostMapping ("/create")
    public void create(@RequestBody Likes request){

            User user=  authService.findByName(authService.getCurrentUser());
            if(user==null){
                return;
            }else {
                Video video =request.getVideo();
               Likes likes= likeService.findByUserAndVideo(user,video);
               if(likes==null){
                   likeService.create(new Likes(request.getLikeStatus(),user,video));
               }else if(likes.getLikeStatus()==request.getLikeStatus()){
                   likeService.deleteLike(likes);
               }else {
                   likes.setLikeStatus(request.getLikeStatus());
                   likeService.create(likes);
               }
            }

    }

    @PostMapping ("/getLike")
    public ResponseEntity<?> getLike(@RequestBody Likes request){

        User user=  authService.findByName(authService.getCurrentUser());
        if(user==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("login first");
        }else {
            Video video =request.getVideo();
            Likes likes= likeService.findByUserAndVideo(user,video);
            return ResponseEntity.ok(likes);
        }




    }
}
>>>>>>> b6e282c763f373846fdb22f3c89214c34615ec78
