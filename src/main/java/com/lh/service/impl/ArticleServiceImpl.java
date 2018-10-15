package com.lh.service.impl;

import com.lh.bean.*;
import com.lh.mapper.ArticleMapper;
import com.lh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service

public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    Tag_Article_Service tag_article_service;
    @Autowired
    TagService tagService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;

    @Override
    public void add(ArticleWithBLOBs article) {
        articleMapper.insertSelective(article);
    }

    @Override
    public void delete(int id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(ArticleWithBLOBs article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }

    @Override
    public void update(Article article) {
        articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public Article get(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArticleWithBLOBs getBLOBS(int id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> list() {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("id desc");
        return articleMapper.selectByExample(example);
    }

    @Override
    public List<Article> listByStatus(int status) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleStatusEqualTo(status);
        example.setOrderByClause("id desc");
        return articleMapper.selectByExample(example);
    }

    @Override
    public List<Article> listByStatusAndUser(int status, int uid) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleStatusEqualTo(status).andArticleUidEqualTo(uid);
        example.setOrderByClause("id desc");
        return articleMapper.selectByExample(example);
    }

    @Override
    public List<Article> listByKey(String key,int status) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleTitleLike("%"+key+"%").andArticleStatusEqualTo(status);
        example.setOrderByClause("id desc");
        return articleMapper.selectByExample(example);
    }
//
//    @Override
//    public List<Article> listByTag(Tag tag, int status, int uid) {
//        List<Article> articles= listByStatusAndUser(status,uid);
//        List<Article> newArt = new ArrayList<>();
//        System.out.println(articles);
//        fillArticle(articles);
//        for (Article article:
//             articles) {
//            System.out.println(tag);
//            System.out.println(article);
//            if(article.getTags().contains(tag))
//                newArt.add(article);
//        }
//        return newArt;
//    }

    @Override
    public List<Article> listByUser(int uid) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleUidEqualTo(uid);
        example.setOrderByClause("id desc");
        return articleMapper.selectByExample(example);
    }

    @Override
    public List<Article> listByCategory(int cid) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria1 = example.createCriteria();
        ArticleExample.Criteria criteria2 = example.createCriteria();
        criteria1.andArticleCpidEqualTo(cid);
        criteria2.andArticleCcidEqualTo(cid);
        example.or(criteria2);
        example.setOrderByClause("id desc");
        return articleMapper.selectByExample(example);
    }

    @Override
    public List<ArticleWithBLOBs> listBLOB() {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("id desc");
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ArticleWithBLOBs> listBLOBByStatus(int status) {
        ArticleExample example = new ArticleExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andArticleStatusEqualTo(status);
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ArticleWithBLOBs> listBLOBByKey(String key) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleTitleLike("%"+key+"%");
        example.setOrderByClause("id desc");
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ArticleWithBLOBs> listBOLOByCategory(int cid) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria1 = example.createCriteria();
        ArticleExample.Criteria criteria2 = example.createCriteria();
        criteria1.andArticleCpidEqualTo(cid);
        criteria2.andArticleCcidEqualTo(cid);
        example.or(criteria2);
        example.setOrderByClause("id desc");
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<ArticleWithBLOBs> listBLOBByUser(int uid) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andArticleUidEqualTo(uid);
        example.setOrderByClause("id desc");
        return articleMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void fillArticleBLOB(ArticleWithBLOBs article) {
        Category c1 = categoryService.get(article.getArticleCpid());
        Category c2 = categoryService.get(article.getArticleCcid());
        article.setParent(c1);
        article.setChildren(c2);
        List<TagArticleKey> tagArticleKeys = tag_article_service.listByAid(article.getId());
        List<Tag> tags = new ArrayList<>();
        for (TagArticleKey tagArticleKey:
                tagArticleKeys) {
            int tid =tagArticleKey.getTid();
            Tag tag = tagService.get(tid);
            tags.add(tag);
        }
        article.setTags(tags);
        User user = userService.get(article.getArticleUid());
        article.setUser(user);
        article.setArticleComments(new Long((long)(commentService.listByArticle(article.getId()).size())));
    }

    @Override
    public void fillArticleBLOB(List<ArticleWithBLOBs> articles) {
        for (ArticleWithBLOBs article:
                articles) {
            fillArticle(article);
        }
    }

    @Override
    public void fillArticle(Article article){
        Category c1 = categoryService.get(article.getArticleCpid());
        Category c2 = categoryService.get(article.getArticleCcid());
        article.setParent(c1);
        article.setChildren(c2);
        List<TagArticleKey> tagArticleKeys = tag_article_service.listByAid(article.getId());
        List<Tag> tags = new ArrayList<>();
        for (TagArticleKey tagArticleKey:
                tagArticleKeys) {
            int tid =tagArticleKey.getTid();
            Tag tag = tagService.get(tid);
            tags.add(tag);
        }
        article.setTags(tags);
        User user = userService.get(article.getArticleUid());
        article.setUser(user);
        article.setArticleComments(new Long((long)(commentService.listByArticle(article.getId()).size())));
    }

    @Override
    public void fillArticle(List<Article> articles) {
        for (Article article:
                articles) {
            fillArticle(article);
        }
    }


}
