package com.lh.service;

import com.lh.bean.Link;

import java.util.List;

public interface LinkService {
    void add(Link link);
    void delete(int id);
    void update(Link link);
    Link get(int id);
    List<Link> list();
    List<Link> listByStatus(int status);
}
