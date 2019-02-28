package com.onlinechese.entys;

import java.io.Serializable;
import java.util.Date;

public class GameList implements Serializable {
    private Long id;

    private String redNickName;

    private String blackNickName;

    private Date created;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRedNickName() {
        return redNickName;
    }

    public void setRedNickName(String redNickName) {
        this.redNickName = redNickName == null ? null : redNickName.trim();
    }

    public String getBlackNickName() {
        return blackNickName;
    }

    public void setBlackNickName(String blackNickName) {
        this.blackNickName = blackNickName == null ? null : blackNickName.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}