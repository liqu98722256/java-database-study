package com.seasun.test;


import com.seasun.dao.IUser;
import com.seasun.dao.IUserInfo;
import com.seasun.domain.Lists;
import com.seasun.domain.User;
import com.seasun.domain.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class IUserTest {
    InputStream resources;
    SqlSessionFactoryBuilder factoryBuilder;
    SqlSessionFactory factory;
    SqlSession session;
    @Before
    public void init() throws IOException {
        resources = Resources.getResourceAsStream("SqlMapConfig.xml");
        factoryBuilder = new SqlSessionFactoryBuilder();
        factory = factoryBuilder.build(resources);
        session = factory.openSession();
    }

    @After
    public void destroy() throws IOException {
        session.close();
        resources.close();
    }

    @Test
    public void testFindAll() throws IOException {
        com.seasun.dao.IUser iUser = session.getMapper(com.seasun.dao.IUser.class);
        IUserInfo iUserInfo = session.getMapper(IUserInfo.class);
        iUser.findAll().forEach(value -> {
            System.out.println(value);
        });
        System.out.println("-------------");
        iUserInfo.findAll().forEach(value -> {
            System.out.println(value);
        });
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("小红");
        user.setSex("female");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setAddress("非洲");
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        mapper.save(user);
        session.commit();
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(15);
        user.setName("小红");
        user.setSex("female");
        user.setAge(18);
        user.setBirthday(new Date());
        user.setAddress("中国");
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        mapper.update(user);
        session.commit();
    }

    @Test
    public void testDestroy() {
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        mapper.destroy(15);
        session.commit();
    }

    @Test
    public void testFindById() {
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        User user = mapper.findById(18);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        List<User> users = mapper.findByName("%红%");
        users.forEach(value -> System.out.println(value));
    }

    @Test
    public void testFindByConditional() {
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        User user = new User();
        user.setSex("female");
        user.setAge(18);
        mapper.findByConditional(user).forEach(System.out::println);
        session.commit();
    }

    @Test
    public void testFindByUserInfo() {
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(19);
        User byUserInfo = mapper.findByUserInfo(userInfo);
        System.out.println(byUserInfo);
    }

    @Test
    public void testFindByCollection() {
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        Lists lists = new Lists();
        mapper.findByCollection(lists).forEach(System.out::println);
    }

    @Test
    public void testFindAllAndAccount() {
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        mapper.findAllAndAccount().forEach(System.out::println);
    }

    @Test
    public void testFindAllAndTag() throws IOException {
        com.seasun.dao.IUser mapper = session.getMapper(com.seasun.dao.IUser.class);
        mapper.findAllAndTag().forEach(System.out::println);
    }
}

