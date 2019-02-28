package com.onlinechese.entys;

import java.io.Serializable;
import java.util.Date;

public class FriendLaunchMessage implements Serializable {
    private Long id;

    private String userName;

    private String nickName;

    private Byte sex;

    private String launchUserName;

    private String launchNickName;

    private Byte launchSex;

    private Integer state;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getLaunchUserName() {
        return launchUserName;
    }

    public void setLaunchUserName(String launchUserName) {
        this.launchUserName = launchUserName == null ? null : launchUserName.trim();
    }

    public String getLaunchNickName() {
        return launchNickName;
    }

    public void setLaunchNickName(String launchNickName) {
        this.launchNickName = launchNickName == null ? null : launchNickName.trim();
    }

    public Byte getLaunchSex() {
        return launchSex;
    }

    public void setLaunchSex(Byte launchSex) {
        this.launchSex = launchSex;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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