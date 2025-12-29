package com.sgt.ExpenseTracker.controller;

import com.sgt.ExpenseTracker.model.User;
import com.sgt.ExpenseTracker.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        return null;
    }
}
