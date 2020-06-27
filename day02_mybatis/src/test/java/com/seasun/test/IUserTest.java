package com.seasun.test;

import com.seasun.dao.IUserDao;
import com.seasun.domain.User;
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
    private InputStream resourceAsStream;
    private SqlSessionFactoryBuilder sqlSourceBuilder;
    private SqlSessionFactory build;
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {
        resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSourceBuilder = new SqlSessionFactoryBuilder();
        build = sqlSourceBuilder.build(resourceAsStream);
    }

    @After
    public void Destroy() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestFindAll() throws IOException {
        sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> users = mapper.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void TestFindById() {
        sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        System.out.println(mapper.findById(1));
    }

    @Test
    public void TestSaveUser() {
        sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("非洲");
        mapper.saveUser(user);
    }

    @Test
    public void TestDestroy() {
        sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        mapper.destroy(1);
    }

    @Test
    public void TestUpdate() {
        sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(2);
        user.setName("李四");
        user.setAge(20);
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("中国");
        mapper.update(user);
    }

    @Test
    public void TestFindByName() {
        sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> byName = mapper.findByName("%李%");
        System.out.println(byName);
    }

    @Test
    public void TestFindForAccount() {
        sqlSession = build.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        List<User> users= mapper.findForAccount();
        users.forEach(System.out::println);
    }
}
