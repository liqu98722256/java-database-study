package com.seasun.test;

import com.seasun.dao.IUser;
import com.seasun.dao.IUserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class IUserInfoTest {
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
        IUserInfo mapper = session.getMapper(IUserInfo.class);
        mapper.findAll().forEach(System.out::println);
    }

}
