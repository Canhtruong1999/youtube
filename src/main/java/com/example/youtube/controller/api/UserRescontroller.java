package com.example.youtube.controller.api;

import com.example.youtube.service.AuthService;
import com.example.youtube.service.request.RegisterSaveRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/api/users")
public class UserRescontroller {
        private final AuthService userService;

    public UserRescontroller(AuthService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid RegisterSaveRequest request){
        userService.create(request);
        return ResponseEntity.noContent().build();
    }
}
