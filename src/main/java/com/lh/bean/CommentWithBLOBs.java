package com.lh.bean;

public class CommentWithBLOBs extends Comment {
    private String commentHtmlText;

    private String commentMdText;

    public String getCommentHtmlText() {
        return commentHtmlText;
    }

    public void setCommentHtmlText(String commentHtmlText) {
        this.commentHtmlText = commentHtmlText == null ? null : commentHtmlText.trim();
    }

    public String getCommentMdText() {
        return commentMdText;
    }

    public void setCommentMdText(String commentMdText) {
        this.commentMdText = commentMdText == null ? null : commentMdText.trim();
    }
}