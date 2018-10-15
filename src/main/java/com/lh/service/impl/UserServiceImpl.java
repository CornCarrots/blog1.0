package com.lh.service.impl;

import com.lh.bean.Article;
import com.lh.bean.User;
import com.lh.bean.UserExample;
import com.lh.mapper.UserMapper;
import com.lh.service.ArticleService;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    ArticleService articleService;

    @Override
    public void add(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User get(String name, String pass) {
        User user = null;
        for (User user1:
             list()) {
            if (user1.getUserName().equals(name)&&user1.getUserPassword().equals(pass))
            {
                user = user1;
                break;
            }
        }
        return user;
    }

    @Override
    public List<User> list() {
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public void fillUser(User user) {
        List<Article> articles = articleService.listByUser(user.getId());
        user.setArticles(articles);
    }

    @Override
    public void fillUser(List<User> users) {
        for (User user:
             users) {
            fillUser(user);
        }
    }

    @Override
    public boolean isExists(String name) {
        for (User user:
             list()) {
            if(user.getUserName().equals(name))
                return true;
        }
        return false;
    }
}
