package com.example.youtube.service;

import com.example.youtube.enums.Role;
import com.example.youtube.model.User;
import com.example.youtube.repository.UserRepository;
import com.example.youtube.service.request.RegisterSaveRequest;
import com.example.youtube.utils.AppUtils;
import jakarta.validation.Valid;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

@Service
public class AuthService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void create(@Valid RegisterSaveRequest request){
        User user= AppUtils.mapper.map(request,User.class);
        userRepository.save(user);
    }
    public void register(com.example.youtube.service.request.@Valid RegisterSaveRequest request){
        var user = AppUtils.mapper.map(request, User.class);
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public boolean checkUsernameOrPhoneNumberOrEmail(com.example.youtube.service.request.@Valid RegisterSaveRequest request, BindingResult result){
        boolean check = false;
        if(userRepository.existsByUsernameIgnoreCase(request.getUsername())){
            result.reject("username", null,
                    "There is already an account registered with the same username");
            check = true;
        }
        if(userRepository.existsByEmailIgnoreCase(request.getEmail())){
            result.reject("email", null,
                    "There is already an account registered with the same email");
            check = true;
        }
        if(userRepository.existsByPhone(request.getPhone())){
            result.reject("phoneNumber", null,
                    "There is already an account registered with the same phone number");
            check = true;
        }
        return check;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameIgnoreCaseOrEmailIgnoreCaseOrPhone(username,username,username)
                .orElseThrow(() -> new UsernameNotFoundException("User not Exist") );
        var role = new ArrayList<SimpleGrantedAuthority>();
        role.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), role);
    }
}
