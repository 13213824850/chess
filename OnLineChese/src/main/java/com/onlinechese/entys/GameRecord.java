package com.onlinechese.entys;

import java.io.Serializable;
import java.util.Date;

public class GameRecord implements Serializable {
    private Long id;

    private String winUserName;

    private String stansportUserName;

    private Integer gameoverResult;

    private Integer type;

    private Date created;

    private Date updated;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWinUserName() {
        return winUserName;
    }

    public void setWinUserName(String winUserName) {
        this.winUserName = winUserName == null ? null : winUserName.trim();
    }

    public String getStansportUserName() {
        return stansportUserName;
    }

    public void setStansportUserName(String stansportUserName) {
        this.stansportUserName = stansportUserName == null ? null : stansportUserName.trim();
    }

    public Integer getGameoverResult() {
        return gameoverResult;
    }

    public void setGameoverResult(Integer gameoverResult) {
        this.gameoverResult = gameoverResult;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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