package com.sgt.ExpenseTracker.Exceptions;

public class UsernameAlreadyExists extends Exception{
    public UsernameAlreadyExists(){
        super("Username Already Exists");
    }
}
