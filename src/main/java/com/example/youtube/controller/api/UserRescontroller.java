package com.example.youtube.controller.api;




import com.example.youtube.Service.AuthService;
import com.example.youtube.Service.UserService;
import com.example.youtube.model.User;
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
        private final AuthService authService;
        private final UserService userService ;
    public UserRescontroller(AuthService authService, UserService userService1) {
        this.authService = authService;
        this.userService = userService1;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid RegisterSaveRequest request){
        authService.create(request);
        return ResponseEntity.noContent().build();
    }

}

