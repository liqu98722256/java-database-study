package com.seasun.dao;

import com.seasun.domain.Account;
import com.seasun.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {
    @Select(value="select * from user")
    @Results(id = "userResultMap",value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "address", column = "address"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.seasun.dao.IAccountDao.findUserById", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    @Select(value="select * from user where id = #{id}")
    User findById(Integer id);

    @Insert(value=
            "insert into user(name, sex, age, birthday, address)" +
            "values(#{name}, #{sex}, #{age}, #{birthday}, #{address});"
    )
    void saveUser(User user);

    @Delete(value=
            "delete from user where id = #{id}"
    )
    void destroy(Integer id);

    @Update(value =
            "update user " +
            "set name = #{name}, age = #{age}, sex = #{sex}, birthday = #{birthday}, address = #{address}" +
            "where id = #{id}"
    )
    void update(User user);

    @Select(value =
            "select * from user where name like #{name}"
    )
    List<User> findByName(String name);

    @Select(value =
            "select * from user"
    )
    @ResultMap(value = "userResultMap")
    List<User> findForAccount();
}
