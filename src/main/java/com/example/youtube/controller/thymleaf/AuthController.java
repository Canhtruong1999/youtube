


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
