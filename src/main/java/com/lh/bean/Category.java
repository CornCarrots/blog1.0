package com.lh.bean;

import java.util.List;

public class Category {
    private Integer id;

    private String categoryName;

    private String categoryDescripe;

    private Integer categoryStatus;

    private Integer pid;

    private List<ArticleWithBLOBs> articles;

    public String categoryStatusDesc()
    {
        String s = "";
        if (categoryStatus==1)
            s = "显示";
        else if(categoryStatus==2)
            s = "隐藏";
        return s;
    }

    public List<ArticleWithBLOBs> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleWithBLOBs> articles) {
        this.articles = articles;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryDescripe() {
        return categoryDescripe;
    }

    public void setCategoryDescripe(String categoryDescripe) {
        this.categoryDescripe = categoryDescripe == null ? null : categoryDescripe.trim();
    }

    public Integer getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Integer categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}