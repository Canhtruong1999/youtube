<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630

package com.example.youtube.controller.thymleaf;

import com.example.youtube.Service.video.VideoService;

import com.example.youtube.Service.video.VideoServiceImpl;
import com.example.youtube.model.Video;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/api/studios")
public class ChanelController {
    private final VideoService videoService;
    private final VideoServiceImpl videoServiceImpl;

    public ChanelController(VideoService videoService, VideoServiceImpl videoServiceImpl) {
        this.videoService = videoService;
        this.videoServiceImpl = videoServiceImpl;
    }

    @GetMapping("/studios")
    public String goStudio(Model model) {
        List<Video> videos = videoServiceImpl.getAllVideos();
        model.addAttribute("videos", videos);
        return "studio";
    }

    @PostMapping
    public ResponseEntity<?> createVideo(@RequestParam("title") String title,
                                         @RequestParam("description") String description,
                                         @RequestParam("image") MultipartFile imageFile,
                                         @RequestParam("video") MultipartFile videoFile,
                                         @RequestParam("tags") List<String> tags) {
        try {
            // Process the uploaded image and video files using the videoService
            String imageUrl = videoService.uploadImage(imageFile);
            String videoUrl = videoService.uploadVideo(videoFile);

            // Now create the video entry in the database or do any other processing
            // For example:
            Video newVideo = new Video();
            newVideo.setTitle(title);
            newVideo.setDescription(description);
            newVideo.setImageUrl(imageUrl);
            newVideo.setVideoUrl(videoUrl);
            // Set other attributes and save to the database using your preferred persistence method.

            // Return a success response or appropriate response based on your use case
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Handle any exceptions that occur during video creation
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create video.");
        }
    }
}

<<<<<<< HEAD
=======
=======

package com.example.youtube.controller.thymleaf;

import com.example.youtube.Service.video.VideoService;

import com.example.youtube.Service.video.VideosService;
import com.example.youtube.Service.video.request.VideoSaveRequuest;
import com.example.youtube.model.Video;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ChanelController {
    private final VideosService videoService;

    public ChanelController(VideosService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/studios")
    public String goStudio(Model model) {
        List<Video> videos = videoService.getAllVideos();
        model.addAttribute("videos", videos);
        return "studio";
    }

    @PostMapping("/createVideo")
    public String createVideo(VideoSaveRequuest videoSaveRequuest) throws IOException {
        MultipartFile imageFile = videoSaveRequuest.getImageFile();
        MultipartFile videoFile = videoSaveRequuest.getVideoFile();
        videoService.createVideo(videoSaveRequuest, imageFile, videoFile);
        return "redirect:/studios";
    }
}

>>>>>>> a0ec43957822d9d53a48f41f02e2920eba66559e
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
