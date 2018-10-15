package com.lh.service;

import com.lh.bean.Comment;
import com.lh.bean.CommentWithBLOBs;

import java.util.List;

public interface CommentService {
    void add(CommentWithBLOBs comment);
    void delete(int id);
    void update(CommentWithBLOBs comment);
    Comment get(int id);
    CommentWithBLOBs getBLOB(int id);
    List<Comment> list();
    List<Comment> listByStatus(int status);
    List<Comment> listByArticle(int aid);
    List<CommentWithBLOBs> listBLOB();
    List<CommentWithBLOBs> listBLOBByUser(int uid);
    List<CommentWithBLOBs> listBLOBByStatus(int status);
    List<CommentWithBLOBs> listBLOBByParAndStatus(int par,int status);
    List<CommentWithBLOBs> listBLOBByArticleAndParAndStatus(int aid,int pid,int status);
    void fillComment(CommentWithBLOBs comment);
    void fillComment(List<CommentWithBLOBs> comments);
}
