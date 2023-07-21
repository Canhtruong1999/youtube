<<<<<<< HEAD
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
>>>>>>> b6e282c763f373846fdb22f3c89214c34615ec78
