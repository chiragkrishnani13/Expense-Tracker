package com.sgt.ExpenseTracker.service;

import com.sgt.ExpenseTracker.model.Category;
import com.sgt.ExpenseTracker.reposistory.CaategoryReposistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    CaategoryReposistory caategoryReposistory;

    public List<Map<String,Object>> getCategory(){
        return this.caategoryReposistory.getCategory();
    }
    public void saveCategory(Category category){
        this.caategoryReposistory.saveCategory(category.getUser_id(),category.getCategory_name(),category.getDescription(),category.getIcon_url(),category.getTranscation_type());
    }
    public List<Category> getCategoryByUserId(int user_id){
        return this.caategoryReposistory.getCategoryByUserId(user_id);
    }
    public int updateCategory(Category category){
        return this.caategoryReposistory.updateCategory(category.getUser_id(),category.getCategory_name(),category.getDescription(),category.getIcon_url(),category.getTranscation_type(),category.getCategory_id());
    }
}
