package com.example.youtube.controller.thymleaf;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class VideoController {
    @GetMapping("/create")
    public String showIndex(){
        return "channelvideo";
    }
}
