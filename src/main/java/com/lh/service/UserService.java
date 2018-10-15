package com.lh.service;

import com.lh.bean.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void add(User user);
    void delete(int id);
    void update(User user);
    User get(int id);
    User get(String name,String pass);
    List<User> list();
    void fillUser(User user);
    void fillUser(List<User> users);
    boolean isExists(String name);

}
