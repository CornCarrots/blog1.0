package com.lh.service.impl;

import com.lh.bean.Article;
import com.lh.bean.Tag;
import com.lh.bean.TagArticleExample;
import com.lh.bean.TagArticleKey;
import com.lh.mapper.TagArticleMapper;
import com.lh.service.Tag_Article_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Tag_Article_ServiceImpl implements Tag_Article_Service {
    @Autowired
    TagArticleMapper tagArticleMapper;

    @Override
    public List<TagArticleKey> listByAid(int aid) {
        TagArticleExample example = new TagArticleExample();
        example.createCriteria().andAidEqualTo(aid);
        example.setOrderByClause("tid desc");
        return tagArticleMapper.selectByExample(example);
    }

    @Override
    public List<TagArticleKey> listByTid(int tid) {
        TagArticleExample example = new TagArticleExample();
        example.createCriteria().andTidEqualTo(tid);
        example.setOrderByClause("aid desc");
        return tagArticleMapper.selectByExample(example);
    }

    @Override
    public void add(Tag tag, Article article) {
        TagArticleKey categoryArticleKey = new TagArticleKey();
        categoryArticleKey.setAid(article.getId());
        categoryArticleKey.setTid(tag.getId());
        tagArticleMapper.insert(categoryArticleKey);
    }

    @Override
    public void update(Tag tag, Article article) {
        TagArticleKey categoryArticleKey = new TagArticleKey();
        categoryArticleKey.setAid(article.getId());
        categoryArticleKey.setTid(tag.getId());
        tagArticleMapper.insert(categoryArticleKey);
    }

    @Override
    public void delete(int tid,int aid) {
        TagArticleKey categoryArticleKey = new TagArticleKey();
        categoryArticleKey.setAid(aid);
        categoryArticleKey.setTid(tid);
        tagArticleMapper.deleteByPrimaryKey(categoryArticleKey);
    }

    @Override
    public List<TagArticleKey> get(int tid, int aid) {
        TagArticleExample example = new TagArticleExample();
        example.createCriteria().andAidEqualTo(aid).andTidEqualTo(tid);
        return tagArticleMapper.selectByExample(example);
    }
}
