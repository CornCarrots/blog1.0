package com.lh.bean;

import com.lh.util.DateUtil;

import java.util.Date;

public class Link {
    private Integer id;

    private String linkUrl;

    private String linkName;

    private String linkDescribe;

    private Date linkCreateDate;

    private Date linkUpdateDate;

    private Integer status;

    public String linkStatusDesc()
    {
        String s = "";
        if (status==1)
            s = "正常";
        else if(status==2)
            s = "待批准";
        return s;
    }

    public String createDateDesc(){

        return DateUtil.format(linkCreateDate);
    }

    public String updateDateDesc(){

        return DateUtil.format(linkUpdateDate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkDescribe() {
        return linkDescribe;
    }

    public void setLinkDescribe(String linkDescribe) {
        this.linkDescribe = linkDescribe == null ? null : linkDescribe.trim();
    }

    public Date getLinkCreateDate() {
        return linkCreateDate;
    }

    public void setLinkCreateDate(Date linkCreateDate) {
        this.linkCreateDate = linkCreateDate;
    }

    public Date getLinkUpdateDate() {
        return linkUpdateDate;
    }

    public void setLinkUpdateDate(Date linkUpdateDate) {
        this.linkUpdateDate = linkUpdateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}