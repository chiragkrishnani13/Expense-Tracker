package com.sgt.ExpenseTracker.Exceptions;

public class EmailAlreadyExistsException extends Exception{
    public EmailAlreadyExistsException(){
        super("Email Already Exists");
    }
}
