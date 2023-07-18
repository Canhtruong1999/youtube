package com.example.youtube.Service.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterSaveRequest {
    private String id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
}
