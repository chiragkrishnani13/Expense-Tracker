package com.sgt.ExpenseTracker.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private int category_id;
    private int user_id;
    private String category_name;
    private String description;
    private String icon_url;
    private String transcation_type;
}
