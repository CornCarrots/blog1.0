package com.lh.bean;

import com.lh.util.DateUtil;

import java.util.Date;

public class Notice {
    private Integer id;

    private String noticeTitle;

    private Date noticeCreateDate;

    private Date noticeUpdateDate;

    private Integer status;

    public String createDateDesc(){

        return DateUtil.format(getNoticeCreateDate());
    }

    public String updateDateDesc(){

        return DateUtil.format(getNoticeUpdateDate());
    }

    public String noticeStatusDesc()
    {
        String s = "";
        if (status==1)
            s = "显示";
        else if(status==2)
            s = "隐藏";
        return s;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public Date getNoticeCreateDate() {
        return noticeCreateDate;
    }

    public void setNoticeCreateDate(Date noticeCreateDate) {
        this.noticeCreateDate = noticeCreateDate;
    }

    public Date getNoticeUpdateDate() {
        return noticeUpdateDate;
    }

    public void setNoticeUpdateDate(Date noticeUpdateDate) {
        this.noticeUpdateDate = noticeUpdateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}