package com.lh.service;

import com.lh.bean.Menu;

import java.util.List;

public interface MenuService {
    void add(Menu menu);
    void delete(int id);
    void update(Menu menu);
    Menu get(int id);
    List<Menu> list();
    List<Menu> listByRole(int role);
}
