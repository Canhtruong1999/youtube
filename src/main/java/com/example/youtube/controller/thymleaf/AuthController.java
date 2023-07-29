<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD
<<<<<<< Updated upstream
>>>>>>> 1495cd4c212385b62bfa4865eb0d2d351ffc8e32

>>>>>>> 7190cba0e363ca23a9167210c16bff37f263ea00

package com.example.youtube.controller.thymleaf;
import com.example.youtube.Service.AuthService;

import com.example.youtube.Service.user.request.RegisterSaveRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {
    @Autowired
    private final AuthService authService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        RegisterSaveRequest user = new RegisterSaveRequest();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") RegisterSaveRequest request,
                               BindingResult result,
                               Model model){
        authService.checkUsernameOrPhoneNumberOrEmail(request, result);
        if(result.hasErrors()){
            return "/register";
        }

        authService.register(request);
        return "redirect:/register?success";
    }
}
<<<<<<< HEAD
=======

<<<<<<< HEAD
=======

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
>>>>>>> bcde6724258af4f83afc4f6aa86aa253689cd780

package com.example.youtube.controller.thymleaf;


import com.example.youtube.Service.AuthService;
import com.example.youtube.service.request.RegisterSaveRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {
    @Autowired
    private final AuthService authService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        RegisterSaveRequest user = new RegisterSaveRequest();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") RegisterSaveRequest request,
                               BindingResult result,
                               Model model){
        authService.checkUsernameOrPhoneNumberOrEmail(request, result);
        if(result.hasErrors()){
            return "/register";
        }

        authService.register(request);
        return "redirect:/register?success";
    }
}

<<<<<<< HEAD
>>>>>>> Stashed changes
=======

<<<<<<< HEAD
=======
=======

package com.example.youtube.controller.thymleaf;


import com.example.youtube.Service.AuthService;
import com.example.youtube.service.request.RegisterSaveRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {
    @Autowired
    private final AuthService authService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        RegisterSaveRequest user = new RegisterSaveRequest();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") RegisterSaveRequest request,
                               BindingResult result,
                               Model model){
        authService.checkUsernameOrPhoneNumberOrEmail(request, result);
        if(result.hasErrors()){
            return "/register";
        }

        authService.register(request);
        return "redirect:/register?success";
    }
}


>>>>>>> a0ec43957822d9d53a48f41f02e2920eba66559e
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
>>>>>>> bcde6724258af4f83afc4f6aa86aa253689cd780
=======
=======

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
>>>>>>> bcde6724258af4f83afc4f6aa86aa253689cd780
>>>>>>> 4377d3d2b63cb6f3b9a070424b3a4149c5d43b17

package com.example.youtube.controller.thymleaf;
import com.example.youtube.Service.AuthService;
import com.example.youtube.service.request.RegisterSaveRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {
    @Autowired
    private final AuthService authService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        RegisterSaveRequest user = new RegisterSaveRequest();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") RegisterSaveRequest request,
                               BindingResult result,
                               Model model){
        authService.checkUsernameOrPhoneNumberOrEmail(request, result);
        if(result.hasErrors()){
            return "/register";
        }

        authService.register(request);
        return "redirect:/register?success";
    }
}
<<<<<<< HEAD
=======

<<<<<<< HEAD
>>>>>>> Stashed changes
=======

<<<<<<< HEAD
=======
=======
>>>>>>> 4d72a10a6ea817d7aa0c72e78955ea98495048e1

package com.example.youtube.controller.thymleaf;


import com.example.youtube.Service.AuthService;
import com.example.youtube.service.request.RegisterSaveRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AuthController {
    @Autowired
    private final AuthService authService;
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        RegisterSaveRequest user = new RegisterSaveRequest();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") RegisterSaveRequest request,
                               BindingResult result,
                               Model model){
        authService.checkUsernameOrPhoneNumberOrEmail(request, result);
        if(result.hasErrors()){
            return "/register";
        }

        authService.register(request);
        return "redirect:/register?success";
    }
}


<<<<<<< HEAD

=======
>>>>>>> a0ec43957822d9d53a48f41f02e2920eba66559e
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
>>>>>>> bcde6724258af4f83afc4f6aa86aa253689cd780
>>>>>>> 4d72a10a6ea817d7aa0c72e78955ea98495048e1
>>>>>>> 1495cd4c212385b62bfa4865eb0d2d351ffc8e32
>>>>>>> 4377d3d2b63cb6f3b9a070424b3a4149c5d43b17
>>>>>>> 7190cba0e363ca23a9167210c16bff37f263ea00
