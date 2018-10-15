package com.lh.service.impl;

import com.lh.bean.Article;
import com.lh.bean.Tag;
import com.lh.bean.TagArticleKey;
import com.lh.bean.TagExample;
import com.lh.mapper.TagMapper;
import com.lh.service.ArticleService;
import com.lh.service.TagService;
import com.lh.service.Tag_Article_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;
    @Autowired
    Tag_Article_Service tag_article_service;
    @Autowired
    ArticleService articleService;

    @Override
    public void add(Tag tag) {
        tagMapper.insertSelective(tag);
    }

    @Override
    public void delete(int id) {
        tagMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Tag tag) {
        tagMapper.updateByPrimaryKeySelective(tag);
    }

    @Override
    public Tag get(int id) {
        return tagMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Tag> list() {
        TagExample example = new TagExample();
        example.setOrderByClause("id desc");
        return tagMapper.selectByExample(example);
    }

    @Override
    public List<Tag> listByStatus(int status) {
        TagExample example = new TagExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andTagStatusEqualTo(status);
        return tagMapper.selectByExample(example);
    }

    @Override
    public void fillTag(Tag tag) {
        List<TagArticleKey> tagArticleKeys = tag_article_service.listByTid(tag.getId());
        List<Article> articles = new ArrayList<>();
        for (TagArticleKey tagArticleKey:
             tagArticleKeys) {
            int aid = tagArticleKey.getAid();
            Article article = articleService.get(aid);
            articles.add(article);
        }
        tag.setArticles(articles);
    }

    @Override
    public void fillTag(List<Tag> tags) {
        for (Tag tag:
             tags) {
            fillTag(tag);
        }
    }
}
