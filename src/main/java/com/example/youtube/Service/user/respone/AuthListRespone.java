package com.example.youtube.Service.user.respone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthListRespone {
    private int id;
    private String email;
    private String phone;
    private String address;
}
