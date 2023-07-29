package com.example.youtube.controller.api;

import com.example.youtube.Service.AuthService;
import com.example.youtube.Service.subscribe.SubscribeService;
import com.example.youtube.model.Subscribe;
import com.example.youtube.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> subscribe(@RequestBody User userSub){
        User user= authService.findByName(authService.getCurrentUser());
        Boolean result=false;
        if(user!=null){
            Subscribe subscribe=subscribeService.findSubscriptionByUserIdAndUserSubId(user,userSub);
            if(subscribe!=null){
                subscribeService.delete(subscribe);
            }else {
                subscribeService.save(new Subscribe(userSub,user));
                result=true;
            }
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("getSubscribe")
    public ResponseEntity<?> getSub(@RequestBody User userSub){
        User user= authService.findByName(authService.getCurrentUser());
        if(user!=null){
            Subscribe subscribe=subscribeService.findSubscriptionByUserIdAndUserSubId(user,userSub);
            if(subscribe!=null){
                return ResponseEntity.ok(true);
            }
        }
        return ResponseEntity.ok(false);
    }
}
