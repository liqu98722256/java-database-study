package com.seasun.dao;

import com.seasun.domain.UserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserInfo {
    /**
     * 通过注解来实现
     * @return
     */
    @Select("select * from user_info")
    List<UserInfo> findAll();
}
