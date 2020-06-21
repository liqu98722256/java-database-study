package com.seasun.dao;

import com.seasun.domain.Lists;
import com.seasun.domain.User;
import com.seasun.domain.UserInfo;

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

    List<User> findByConditional(User user);

    User findByUserInfo(UserInfo userInfo);

    List<User> findByCollection(Lists lists);

    List<User> findAllAndAccount();

    List<User> findAllAndTag();
}
