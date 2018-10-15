package com.lh.service.impl;

import com.lh.bean.*;
import com.lh.mapper.CommentMapper;
import com.lh.service.ArticleService;
import com.lh.service.CommentService;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;

    @Override
    public void add(CommentWithBLOBs comment) {
        commentMapper.insertSelective(comment);
    }

    @Override
    public void delete(int id) {
        commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(CommentWithBLOBs comment) {
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    @Cacheable(value = "CacheComment",key = "'comments-'+#p0")
    public Comment get(int id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommentWithBLOBs getBLOB(int id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Comment> list() {
        CommentExample example = new CommentExample();
        example.setOrderByClause("id desc");
        return commentMapper.selectByExample(example);
    }

    @Override
    public List<Comment> listByStatus(int status) {
        CommentExample example = new CommentExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andCommentStatusEqualTo(status);
        return commentMapper.selectByExample(example);
    }

    @Override
    public List<Comment> listByArticle(int aid) {
        CommentExample example = new CommentExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andAidEqualTo(aid);
        return commentMapper.selectByExample(example);
    }

    @Override
    public List<CommentWithBLOBs> listBLOB() {
        CommentExample example = new CommentExample();
        example.setOrderByClause("id desc");
        return commentMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<CommentWithBLOBs> listBLOBByUser(int uid) {

        List<Article> articles = articleService.listByStatusAndUser(1,uid);

        List<CommentWithBLOBs> list = new ArrayList<>();
        int i = 0;
        for (Article article:
             articles) {
            CommentExample example = new CommentExample();
            example.setOrderByClause("id desc");
            example.createCriteria().andAidEqualTo(article.getId());
            List<CommentWithBLOBs> list1 = commentMapper.selectByExampleWithBLOBs(example);
            if(list1.size()==0)
                continue;
            list.addAll(i,list1);
            i+=list1.size();
        }
        return list;
    }

    @Override
    public List<CommentWithBLOBs> listBLOBByStatus(int status) {
        CommentExample example = new CommentExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andCommentStatusEqualTo(status);
        return commentMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<CommentWithBLOBs> listBLOBByParAndStatus(int par,int status) {
        CommentExample example = new CommentExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andPidEqualTo(par).andCommentStatusEqualTo(status);
        return commentMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<CommentWithBLOBs> listBLOBByArticleAndParAndStatus(int aid,int pid,int status) {
        CommentExample example = new CommentExample();
        example.setOrderByClause("id desc");
        example.createCriteria().andAidEqualTo(aid).andPidEqualTo(pid).andCommentStatusEqualTo(status);
        return commentMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public void fillComment(CommentWithBLOBs comment) {
        int uid = comment.getUid();
        User user = userService.get(uid);
        comment.setUser(user);
        int aid = comment.getAid();
        Article article = articleService.get(aid);
        List<CommentWithBLOBs> comments = listBLOBByParAndStatus(comment.getId(),2);
        fillComment(comments);
        comment.setChild(comments);
        comment.setArticle(article);
        if (comment.getPid()!=0)
        {
            Comment parent = get(comment.getPid());
            comment.setParent(parent);
        }
    }

    @Override
    public void fillComment(List<CommentWithBLOBs> comments) {
        for (CommentWithBLOBs comment:
             comments) {
            fillComment(comment);
        }
    }
}
