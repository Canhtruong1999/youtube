<<<<<<< HEAD
package com.example.youtube.controller.thymleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String gohome(){
        return "index";
    }
}
=======
package com.example.youtube.controller.thymleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String gohome(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
}
>>>>>>> b6e282c763f373846fdb22f3c89214c34615ec78
