package com.sgt.ExpenseTracker.controller;

import com.sgt.ExpenseTracker.Exceptions.EmailAlreadyExistsException;
import com.sgt.ExpenseTracker.Exceptions.EmailInvalidException;
import com.sgt.ExpenseTracker.Exceptions.UsernameAlreadyExists;
import com.sgt.ExpenseTracker.model.User;
import com.sgt.ExpenseTracker.service.AuthService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try {
            this.authService.register(user);
        }
        catch (DuplicateKeyException e){
            return ResponseEntity.badRequest().body(Map.of("body","Email already exists!!"));

        }
        catch (UsernameAlreadyExists e){
            return ResponseEntity.badRequest().body(Map.of("body","Username already exists!!"));

        } catch (EmailInvalidException e) {
            return ResponseEntity.badRequest().body(Map.of("body","Email Invalid!!"));
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(Map.of("body","Email Already Exists!!"));
        }
        return ResponseEntity.badRequest().body(Map.of("body","Inserted Succesfully!!"));
    }
    @GetMapping("/users")
    public List<Map<String,Object>> getUsers(){
        return this.authService.getUsers();
    }

}
