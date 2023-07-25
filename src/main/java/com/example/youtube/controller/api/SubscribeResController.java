package com.example.youtube.controller.api;

import com.example.youtube.Service.AuthService;
import com.example.youtube.Service.subscribe.SubscribeService;
import com.example.youtube.model.Subscribe;
import com.example.youtube.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscribes")
public class SubscribeResController {

    private final AuthService authService;
    private final SubscribeService subscribeService;

    public SubscribeResController(AuthService authService, SubscribeService subscribeService) {
        this.authService = authService;
        this.subscribeService = subscribeService;
    }

    @PostMapping
    public void subscribe(@RequestBody User userSub){
        User user= authService.findByName(authService.getCurrentUser());
        if(user!=null){
            subscribeService.save(new Subscribe(userSub,user));
        }
    }
}
