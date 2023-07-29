
package com.example.youtube.controller.thymleaf;

import com.example.youtube.Service.AuthService;
import com.example.youtube.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    private final AuthService authService;

    public HomeController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/home")
<<<<<<< HEAD
    public String gohome(Model model){
        model.addAttribute("userLogin",  authService.findByName(authService.getCurrentUser()));
=======
    public String gohome(){

>>>>>>> 7190cba0e363ca23a9167210c16bff37f263ea00
        return "index";
    }
    @GetMapping("login")
    public String login(){
        return "login";}}
