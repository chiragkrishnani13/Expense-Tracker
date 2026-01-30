package com.sgt.ExpenseTracker.reposistory;

import com.sgt.ExpenseTracker.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CaategoryReposistory {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> getCategory(){
        String query = "select * from categorys";
        return jdbcTemplate.queryForList(query);
    }
    public void saveCategory(int user_id,String category_name,String description,String icon_url,String transcation_type){
        String query = "INSERT INTO categorys(user_id, category_name, description, icon_url, transcation_type)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(query,user_id,category_name,description,icon_url,transcation_type);

    }
    public List<Category> getCategoryByUserId(int user_id){
        String query = "select * from categorys where user_id = ?";
        return jdbcTemplate.query(query,(rs, rowNum) -> {
            Category category = new Category();
            category.setCategory_id(rs.getInt("category_id"));
            category.setUser_id(rs.getInt("user_id"));
            category.setCategory_name(rs.getString("category_name"));
            category.setDescription(rs.getString("description"));
            category.setIcon_url(rs.getString("icon_url"));
            category.setTranscation_type(rs.getString("transcation_type"));
            return category;
        },user_id);
    }
    public int  updateCategory(int user_id,String category_name,String description,String icon_url,String transcation_type,int category_id){
        String query = "update categorys set user_id =?,category_name=?,description=?,icon_url=?,transcation_type=? where category_id=?";
        return jdbcTemplate.update(query,user_id,category_name,description,icon_url,transcation_type,category_id);
    }

}
