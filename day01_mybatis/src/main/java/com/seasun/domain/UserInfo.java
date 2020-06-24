package com.seasun.domain;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private Integer id;
    private Integer uid;
    private Integer height;
    private Integer weight;

    private User user;

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

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", height=" + height +
                ", weight=" + weight +
                ", user=" + user +
                '}';
    }
}
