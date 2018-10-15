package com.lh.bean;

public class ArticleWithBLOBs extends Article {
    private String articleMdText;

    private String articleHtmlText;

    public String getArticleMdText() {
        return articleMdText;
    }

    public void setArticleMdText(String articleMdText) {
        this.articleMdText = articleMdText == null ? null : articleMdText.trim();
    }

    public String getArticleHtmlText() {
        return articleHtmlText;
    }

    public void setArticleHtmlText(String articleHtmlText) {
        this.articleHtmlText = articleHtmlText == null ? null : articleHtmlText.trim();
    }
}