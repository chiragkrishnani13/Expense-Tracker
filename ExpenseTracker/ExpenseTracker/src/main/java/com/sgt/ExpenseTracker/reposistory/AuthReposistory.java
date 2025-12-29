package com.sgt.ExpenseTracker.reposistory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthReposistory {
    JdbcTemplate jdbcTemplate;
}
