package com.sgt.ExpenseTracker.reposistory;

import com.sgt.ExpenseTracker.model.User;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class AuthReposistory {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void register(String email,String username,String name,String password,String phone_no){
        String query = "INSERT INTO users (email, username, name, password, phone_no) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(query,email,username,name,password,phone_no);
    }
    public List<Map<String,Object>> getUsers(){
        String query = "Select user_id,email,username,name,password,phone_no from users where active_yn = 1";
        return jdbcTemplate.queryForList(query);

    }
    public User findByEmail(String email){
        String query = "SELECT user_id,email,username,name,password,phone_no,active_yn FROM users where email=?";
        try{
            return jdbcTemplate.queryForObject(query,(rs, rowNum) ->{
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setActive_yn(rs.getInt("active_yn"));
                user.setPhone_no(rs.getString("phone_no"));
                return user;
            } ,email);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    public User findByUserName(String username){
        String query = "SELECT user_id,email,username,name,password,phone_no,active_yn FROM users where username=?";
        try{
            return jdbcTemplate.queryForObject(query,(rs, rowNum) ->{
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setActive_yn(rs.getInt("active_yn"));
                user.setPhone_no(rs.getString("phone_no"));
                return user;
            } ,username);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }

    }
}
