package com.example.tugasifapps2.Model;


public class LoginRequest {
    String email;
    String password;
    String role;

    public LoginRequest(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
