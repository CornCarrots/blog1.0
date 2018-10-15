package com.lh.bean;

public class NoticeWithBLOBs extends Notice {
    private String noticeHtmlText;

    private String noticeMdText;

    public String getNoticeHtmlText() {
        return noticeHtmlText;
    }

    public void setNoticeHtmlText(String noticeHtmlText) {
        this.noticeHtmlText = noticeHtmlText == null ? null : noticeHtmlText.trim();
    }

    public String getNoticeMdText() {
        return noticeMdText;
    }

    public void setNoticeMdText(String noticeMdText) {
        this.noticeMdText = noticeMdText == null ? null : noticeMdText.trim();
    }
}