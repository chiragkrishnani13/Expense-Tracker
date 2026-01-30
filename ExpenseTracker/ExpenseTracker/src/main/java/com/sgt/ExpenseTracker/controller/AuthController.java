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

@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try {
            this.authService.register(user);
        }
        catch (UsernameAlreadyExists e){
            return ResponseEntity.badRequest().body(Map.of("body",e.getMessage()));
        } catch (EmailInvalidException e) {
            return ResponseEntity.badRequest().body(Map.of("body",e.getMessage()));
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(Map.of("body",e.getMessage()));
        }
        return ResponseEntity.ok().body(Map.of("body","Inserted Succesfully!!"));
    }
    @GetMapping("/users")
    public List<Map<String,Object>> getUsers(){
        return this.authService.getUsers();
    }

    @PostMapping("/forget-password")
    public ResponseEntity<?> forgetPassword(@RequestBody Map<String,String> body)  {
        try {
            this.authService.forgetPassword(body);
        }
        catch (EmailInvalidException e){
            return ResponseEntity.badRequest().body(Map.of("body",e.getMessage()));
        }
        return ResponseEntity.ok().body(Map.of("body","User Valid!!"));
    }
    @PostMapping("valid-token")
    public ResponseEntity<?> validToken(@RequestBody Map<String,String> token) {
        if(this.authService.validToken(token)){
            System.out.println("Not Valid");
            return ResponseEntity.badRequest().body(Map.of("body","Token Time Expired"));
        }
        System.out.println("valid");
        return ResponseEntity.ok().body(Map.of("body","Token Valid!!"));
    }
    @PostMapping("update-password")
    public ResponseEntity<?> updatePassword(@RequestBody Map<String,String> data){
        if(this.authService.updatePassword(data)){
            return ResponseEntity.ok().body(Map.of("body","Password Updated"));
        }
        else{
            return ResponseEntity.badRequest().body(Map.of("body","Token Time Expired"));
        }


    }

}
