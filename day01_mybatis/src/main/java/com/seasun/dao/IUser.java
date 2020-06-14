package com.seasun.dao;

import com.seasun.domain.User;

import java.util.List;

public interface IUser {
    /**
     * 通过配置文件的方式来实现
     * @return
     */
    List<User> findAll();

    void save(User user);

    void update(User user);

    void destroy(Integer uid);

    User findById(Integer uid);

    List<User> findByName(String name);
}
