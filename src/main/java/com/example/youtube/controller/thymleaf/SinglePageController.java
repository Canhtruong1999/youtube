package com.example.youtube.controller.thymleaf;

import com.example.youtube.model.Likes;
import com.example.youtube.repository.VideoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/singlePages")
public class SinglePageController{
    private final VideoRepository videoRepository;



    public SinglePageController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping("/show")
    public String showSinglePages(@RequestParam int id, Model model){
       model.addAttribute("video", videoRepository.findById(id));

        return "single_page";
    }
}
