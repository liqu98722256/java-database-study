package com.seasun.dao;

import com.seasun.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {
    @Select(value="select * from user")
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
}
