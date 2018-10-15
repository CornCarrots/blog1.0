package com.lh.bean;

public class UserFriend {
    private Integer id;

    private Integer uid;

    private Integer friendUid;

    private Integer friendStatus;

    private String friendNote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getFriendUid() {
        return friendUid;
    }

    public void setFriendUid(Integer friendUid) {
        this.friendUid = friendUid;
    }

    public Integer getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(Integer friendStatus) {
        this.friendStatus = friendStatus;
    }

    public String getFriendNote() {
        return friendNote;
    }

    public void setFriendNote(String friendNote) {
        this.friendNote = friendNote == null ? null : friendNote.trim();
    }
}