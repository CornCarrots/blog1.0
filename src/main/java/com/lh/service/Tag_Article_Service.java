package com.lh.service;

import com.lh.bean.Article;
import com.lh.bean.Tag;
import com.lh.bean.TagArticleKey;

import java.util.List;

public interface Tag_Article_Service {
    List<TagArticleKey> listByAid(int aid);
    List<TagArticleKey> listByTid(int tid);
    void add(Tag tag,Article article);
    void update(Tag tag,Article article);
    void delete(int tid,int aid);
    List<TagArticleKey> get(int tid,int aid);

}
