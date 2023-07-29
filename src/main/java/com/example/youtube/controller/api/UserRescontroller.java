<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 4d72a10a6ea817d7aa0c72e78955ea98495048e1

>>>>>>> 1495cd4c212385b62bfa4865eb0d2d351ffc8e32
>>>>>>> 7190cba0e363ca23a9167210c16bff37f263ea00
package com.example.youtube.controller.api;

import com.example.youtube.Service.AuthService;

import com.example.youtube.Service.user.request.RegisterSaveRequest;
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


<<<<<<< HEAD

=======
<<<<<<< HEAD
=======
=======
<<<<<<< HEAD
>>>>>>> 4377d3d2b63cb6f3b9a070424b3a4149c5d43b17
package com.example.youtube.controller.api;

import com.example.youtube.Service.AuthService;
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



<<<<<<< HEAD
=======


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

>>>>>>> a0ec43957822d9d53a48f41f02e2920eba66559e
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
>>>>>>> bcde6724258af4f83afc4f6aa86aa253689cd780
>>>>>>> 4d72a10a6ea817d7aa0c72e78955ea98495048e1
>>>>>>> 1495cd4c212385b62bfa4865eb0d2d351ffc8e32
>>>>>>> 4377d3d2b63cb6f3b9a070424b3a4149c5d43b17
>>>>>>> 7190cba0e363ca23a9167210c16bff37f263ea00
