package com.seasun.domain;

import com.seasun.domain.User;

public class Account {
    private Integer id;
    private Integer uid;
    private String username;
    private String password;
    private User user;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user=" + user +
                '}';
    }
}
