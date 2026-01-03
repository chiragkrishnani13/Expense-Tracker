package com.sgt.ExpenseTracker.service;

import com.sgt.ExpenseTracker.Exceptions.EmailAlreadyExistsException;
import com.sgt.ExpenseTracker.Exceptions.EmailInvalidException;
import com.sgt.ExpenseTracker.Exceptions.UsernameAlreadyExists;
import com.sgt.ExpenseTracker.model.User;
import com.sgt.ExpenseTracker.reposistory.AuthReposistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthService {
    @Autowired
    AuthReposistory authReposistory;
    Logger logger = LoggerFactory.getLogger(AuthService.class);
    public void register(User user) throws EmailInvalidException, UsernameAlreadyExists, EmailAlreadyExistsException {
         if (!this.isEmailValid(user.getEmail())) {
             throw new EmailInvalidException();
        } else if (this.authReposistory.findByEmail(user.getEmail()) !=null) {
             throw new EmailAlreadyExistsException();

         } else if (this.authReposistory.findByUserName(user.getUsername()) != null) {
             logger.debug("Come here");

             throw new UsernameAlreadyExists();
         } else {
             this.authReposistory.register(user.getEmail(),user.getUsername(),user.getName(),user.getPassword(),user.getPhone_no());

        }


//    check validatity of email
//     check if email already exists
//        check if username already exists
//        hash the password
    }
    public List<Map<String,Object>> getUsers(){
        return this.authReposistory.getUsers() ;
    }
    public boolean isEmailValid(String email) {
        if(email==null) return false;
        String REGEX = "^[A-Za-z0-9_+.]+@[A-Za-z0-9_+.]+\\.[a-z]{2,}$";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


}
