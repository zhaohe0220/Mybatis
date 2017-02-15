package com.mybatis.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by yunfei on 2017/2/14.
 */
public class DBAccess {
    public SqlSession getSqlSession() throws IOException {
        //文件获取数据库连接信息
        Reader reader = Resources.getResourceAsReader("com/mybatis/config/Configuration.xml");
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //打开数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
