package com.seasun.test;

import com.seasun.dao.IAccount;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class IAccountTest {
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
        session.commit();
        session.close();
        resources.close();
    }

    @Test
    public void testFindAll() throws IOException {
        IAccount mapper = session.getMapper(IAccount.class);
        mapper.findAll().forEach(System.out::println);
    }

    @Test
    public void testFindById() throws IOException {
        IAccount mapper = session.getMapper(IAccount.class);
        System.out.println(mapper.findById(1));
    }
}
