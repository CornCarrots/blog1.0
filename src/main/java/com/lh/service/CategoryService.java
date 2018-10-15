package com.lh.service;

import com.lh.bean.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);
    void delete(int id);
    void update(Category category);
    Category get(int id);
    List<Category> list();
    List<Category> listByStatus(int status);
    Boolean hasParent(Category category);
    Boolean hasChild(Category category);
    List<Category> listByParent(int pid);
    List<Category> listChild();
    void fillCategory(Category category);
    void fillCategory(List<Category> categories);
}
