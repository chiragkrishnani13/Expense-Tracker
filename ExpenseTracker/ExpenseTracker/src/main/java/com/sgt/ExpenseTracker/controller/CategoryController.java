package com.sgt.ExpenseTracker.controller;

import com.sgt.ExpenseTracker.model.Category;
import com.sgt.ExpenseTracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public List<Map<String,Object>> getCategory(){
        return this.categoryService.getCategory();
    }
    @PostMapping("/category")
    public void saveCategory(@RequestBody Category category){
        this.categoryService.saveCategory(category);
    }
    @GetMapping("/category/{user_id}")
    public List<Category> getCategoryByUserId(@PathVariable(name = "user_id") int user_id){
        return this.categoryService.getCategoryByUserId(user_id);
    }
    @PutMapping("/category")
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
         int res  = this.categoryService.updateCategory(category);
         if(res==0){
             return ResponseEntity.badRequest().body(Map.of("body","Something went Wrong"));
         }
         return ResponseEntity.ok().body(Map.of("message","Category Updated"));

    }



}
