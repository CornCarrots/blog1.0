package com.lh.bean;

import com.lh.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Comment {
    private Integer id;

    private Date commentCreateDate;

    private String commentIp;

    private Integer commentStatus;

    private Integer pid;

    private Integer uid;

    private Integer aid;

    private Article article;

    private User user;

    private Comment parent;

    private List<CommentWithBLOBs> child;

    public List<CommentWithBLOBs> getChild() {
        return child;
    }

    public void setChild(List<CommentWithBLOBs> child) {
        this.child = child;
    }

    public String createDateDesc()
    {
        return DateUtil.format(commentCreateDate);
    }

    public String createDateDesc2()
    {
        String str = "";
        if(commentCreateDate!=null)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            str = dateFormat.format(commentCreateDate);
        }
        return str;
    }

    public String statusDesc()
    {
        String s = "";
        switch (commentStatus)
        {
            case 1:
                s="待审核";
                break;
            case 2:
                s = "已通过";
                break;
            case 3:
                s = "已屏蔽";
        }
        return s;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCommentCreateDate() {
        return commentCreateDate;
    }

    public void setCommentCreateDate(Date commentCreateDate) {
        this.commentCreateDate = commentCreateDate;
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp == null ? null : commentIp.trim();
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", commentCreateDate=" + commentCreateDate +
                ", commentIp='" + commentIp + '\'' +
                ", commentStatus=" + commentStatus +
                ", pid=" + pid +
                ", uid=" + uid +
                ", aid=" + aid +
//                ", article=" + article +
//                ", user=" + user +
//                ", parent=" + parent +
//                ", child=" + child +
                '}';
    }
}