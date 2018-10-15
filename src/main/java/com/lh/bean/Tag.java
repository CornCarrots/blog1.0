package com.lh.bean;

import java.util.List;

public class Tag {
    private Integer id;

    private String tagName;

    private String tagDescripe;

    private Integer tagStatus;

    private List<Article> articles;

    public String tagStatusDesc()
    {
        String s = "";
        if (tagStatus==1)
            s = "显示";
        else if(tagStatus==2)
            s = "隐藏";
        return s;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getTagDescripe() {
        return tagDescripe;
    }

    public void setTagDescripe(String tagDescripe) {
        this.tagDescripe = tagDescripe == null ? null : tagDescripe.trim();
    }

    public Integer getTagStatus() {
        return tagStatus;
    }

    public void setTagStatus(Integer tagStatus) {
        this.tagStatus = tagStatus;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", tagDescripe='" + tagDescripe + '\'' +
                ", tagStatus=" + tagStatus +
                ", articles=" + articles +
                '}';
    }
}