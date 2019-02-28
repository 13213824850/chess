package com.onlinechese.entys;

import java.io.Serializable;
import java.util.Date;

public class Friend implements Serializable {
    private Long id;

    private String userName;

    private String friendName;

    private String friendNickName;

    private Byte friendSex;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName == null ? null : friendName.trim();
    }

    public String getFriendNickName() {
        return friendNickName;
    }

    public void setFriendNickName(String friendNickName) {
        this.friendNickName = friendNickName == null ? null : friendNickName.trim();
    }

    public Byte getFriendSex() {
        return friendSex;
    }

    public void setFriendSex(Byte friendSex) {
        this.friendSex = friendSex;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}