package com.onlinechese.entys;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class Rank implements Serializable {
    private Long id;

    private String userName;

    private Integer rankGrade;

    private Integer rankGradeStage;

    private Integer star;

    private Integer protectCount;

    private Integer winCount;

    private Integer transportCount;

    private Integer continusTransport;

    private Integer continusWin;

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

    public Integer getRankGrade() {
        return rankGrade;
    }

    public void setRankGrade(Integer rankGrade) {
        this.rankGrade = rankGrade;
    }

    public Integer getRankGradeStage() {
        return rankGradeStage;
    }

    public void setRankGradeStage(Integer rankGradeStage) {
        this.rankGradeStage = rankGradeStage;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getProtectCount() {
        return protectCount;
    }

    public void setProtectCount(Integer protectCount) {
        this.protectCount = protectCount;
    }

    public Integer getWinCount() {
        return winCount;
    }

    public void setWinCount(Integer winCount) {
        this.winCount = winCount;
    }

    public Integer getTransportCount() {
        return transportCount;
    }

    public void setTransportCount(Integer transportCount) {
        this.transportCount = transportCount;
    }

    public Integer getContinusTransport() {
        return continusTransport;
    }

    public void setContinusTransport(Integer continusTransport) {
        this.continusTransport = continusTransport;
    }

    public Integer getContinusWin() {
        return continusWin;
    }

    public void setContinusWin(Integer continusWin) {
        this.continusWin = continusWin;
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