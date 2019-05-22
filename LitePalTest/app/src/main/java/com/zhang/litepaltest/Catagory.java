package com.zhang.litepaltest;

import org.litepal.crud.LitePalSupport;

public class Catagory extends LitePalSupport {
    private int id;

    private String categoryName;

    private int categoryCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }
}
