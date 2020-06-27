package com.seasun.dao;

import com.seasun.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {
    @Select(value =
        "select * from account"
    )
    @Results(id = "accountResultMap", value = {
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "uid", column = "uid"),
        @Result(property = "username", column = "username"),
        @Result(property = "password", column = "password"),
        @Result(property = "user", column = "uid",
                one = @One(select = "com.seasun.dao.IUserDao.findById", fetchType = FetchType.LAZY)
        ),
    })
    List<Account> findAll();

    @Select(value =
        "select * from account where id = #{id}"
    )
    Account findById(Integer id);

    @Select(value =
            "select * from account where uid = #{id}"
    )
    List<Account> findUserById(Integer id);
}
