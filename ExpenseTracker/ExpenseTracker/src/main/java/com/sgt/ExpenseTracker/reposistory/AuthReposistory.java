package com.sgt.ExpenseTracker.reposistory;

import com.sgt.ExpenseTracker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public class AuthReposistory {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void save(String email, String username, String name, String password, String phone_no){
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
    public void saveResetToken(String token, int user_id, LocalDateTime expiry){
        String query = "INSERT INTO auth_Tokens (token, user_id, expiry) VALUES (?,?,?)";
        jdbcTemplate.update(query,token,user_id,expiry);
    }
    public Map<?,?> validToken(String token){
        String query = "select * from auth_Tokens where token = ? and expiry > current_timestamp";
        Map<?,?> res;
        try {
             res = jdbcTemplate.queryForMap(query,token);
        }
        catch (Exception e){
            return null;
        }
        return res;

    }
    public void updatePassword(String password,String token,int user_id){
        String query = "update users set password = ? where user_id = ?";
        String query1 = "update auth_Tokens set used_yn = 1 where user_id = ? and token = ?";


        jdbcTemplate.update(query,password,user_id);
        jdbcTemplate.update(query1,user_id,token);
    }
    public Map<?,?> findUserByToken(String token){
        String query = "select user_id from auth_Tokens where token = ? and expiry > current_timestamp";
        Map<?,?> res = Map.of();
        try{
             res = jdbcTemplate.queryForMap(query,token);
            System.out.println(res);
        }
        catch (Exception e){
            System.out.println(res);
            return null;
        }
        return res;

    }
    public Map<?,?> checkTokenAlreadyExist(String email){
        String query="select users.user_id from users inner join auth_Tokens on users.user_id = auth_Tokens.user_id and email = ?";
        Map<?,?> res;
        try{
            res = jdbcTemplate.queryForMap(query,email);
        }
        catch (Exception e){
            return null;
        }
        return res;

    }
    public int updateTokenExpiry(int user_id,LocalDateTime expiry){
        String query = "update auth_Tokens set expiry = ? where user_id = ?";
         return jdbcTemplate.update(query,expiry,user_id);

    }
    public Map<?,?> updateTokenByUserID(int user_id){
        String query = "select token from auth_Tokens where user_id = ? ";
        return jdbcTemplate.queryForMap(query,user_id);
    }

}
