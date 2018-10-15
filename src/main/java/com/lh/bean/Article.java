package com.lh.bean;

import com.lh.util.DateUtil;

import java.util.Date;
import java.util.List;

public class Article {
    private Integer id;

    private String articleTitle;

    private Integer articleUid;

    private Integer articleCpid;

    private Integer articleCcid;

    private Date articleCreateDate;

    private Date articleUpdateDate;

    private Integer articleStatus;

    private Long articleViews;

    private Long articleLikes;

    private Long articleComments;

  private Category parent;

    private Category children;

    private List<Tag> tags;

    private User user;

    public String createDateDesc(){

        return DateUtil.format(getArticleCreateDate());
    }

    public String updateDateDesc(){

        return DateUtil.format(getArticleUpdateDate());
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Category getChildren() {
        return children;
    }

    public void setChildren(Category children) {
        this.children = children;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getArticleUid() {
        return articleUid;
    }

    public void setArticleUid(Integer articleUid) {
        this.articleUid = articleUid;
    }

    public Integer getArticleCpid() {
        return articleCpid;
    }

    public void setArticleCpid(Integer articleCpid) {
        this.articleCpid = articleCpid;
    }

    public Integer getArticleCcid() {
        return articleCcid;
    }

    public void setArticleCcid(Integer articleCcid) {
        this.articleCcid = articleCcid;
    }

    public Date getArticleCreateDate() {
        return articleCreateDate;
    }

    public void setArticleCreateDate(Date articleCreateDate) {
        this.articleCreateDate = articleCreateDate;
    }

    public Date getArticleUpdateDate() {
        return articleUpdateDate;
    }

    public void setArticleUpdateDate(Date articleUpdateDate) {
        this.articleUpdateDate = articleUpdateDate;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Long getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Long articleViews) {
        this.articleViews = articleViews;
    }

    public Long getArticleLikes() {
        return articleLikes;
    }

    public void setArticleLikes(Long articleLikes) {
        this.articleLikes = articleLikes;
    }

    public Long getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(Long articleComments) {
        this.articleComments = articleComments;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleUid=" + articleUid +
                ", articleCpid=" + articleCpid +
                ", articleCcid=" + articleCcid +
                ", articleCreateDate=" + articleCreateDate +
                ", articleUpdateDate=" + articleUpdateDate +
                ", articleStatus=" + articleStatus +
                ", articleViews=" + articleViews +
                ", articleLikes=" + articleLikes +
                ", articleComments=" + articleComments +
//                ", parent=" + parent +
//                ", children=" + children +
//                ", tags=" + tags +
//                ", user=" + user +
                '}';
    }
}