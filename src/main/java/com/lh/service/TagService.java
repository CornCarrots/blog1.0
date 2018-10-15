package com.lh.service;

import com.lh.bean.Tag;

import java.util.List;

public interface TagService {
    void add(Tag tag);
    void delete(int id);
    void update(Tag tag);
    Tag get(int id);
    List<Tag> list();
    List<Tag> listByStatus(int status);
    void fillTag(Tag tag);
    void fillTag(List<Tag> tags);
}
