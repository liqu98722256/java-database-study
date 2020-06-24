package com.seasun.dao;

import com.seasun.domain.UserInfo;

import java.util.List;

public interface IUserInfo {
    List<UserInfo> findAll();
}
