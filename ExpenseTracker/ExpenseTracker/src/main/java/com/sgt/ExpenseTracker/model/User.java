package com.sgt.ExpenseTracker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int user_id;
    private String name;
    private String email;
    private String username;
    private String password;
    private String phone_no;
    private int active_yn;
}
