package com.seasun.test;

import com.seasun.dao.IAccountDao;
import com.seasun.dao.IUserDao;
import com.seasun.domain.Account;
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
import java.util.List;

public class IAccountTest {
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
        IAccountDao mapper = sqlSession.getMapper(IAccountDao.class);
        mapper.findAll().forEach(System.out::println);
    }
}
