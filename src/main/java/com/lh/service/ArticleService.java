package com.lh.service;

import com.lh.bean.Article;
import com.lh.bean.ArticleWithBLOBs;
import com.lh.bean.Tag;

import java.util.List;

public interface ArticleService {
    void add(ArticleWithBLOBs article);
    void delete(int id);
    void update(ArticleWithBLOBs article);
    void update(Article article);
    Article get(int id);
    ArticleWithBLOBs getBLOBS(int id);
    List<Article> list();
    List<Article> listByStatus(int status);
    List<Article> listByStatusAndUser(int status,int uid);
    List<Article> listByKey(String key,int status);
//    List<Article> listByTag(Tag tag, int status, int uid);
    List<Article> listByUser(int uid);
    List<Article> listByCategory(int cid);
    List<ArticleWithBLOBs> listBLOB();
    List<ArticleWithBLOBs> listBLOBByStatus(int status);
    List<ArticleWithBLOBs> listBLOBByKey(String key);
    List<ArticleWithBLOBs> listBOLOByCategory(int cid);
    List<ArticleWithBLOBs> listBLOBByUser(int uid);
    void fillArticleBLOB(ArticleWithBLOBs article);
    void fillArticleBLOB(List<ArticleWithBLOBs> articles);
    void fillArticle(Article article);
    void fillArticle(List<Article> articles);
}
