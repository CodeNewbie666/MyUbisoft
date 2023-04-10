package com.until;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUntil {
    static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            //1.先使用Resource获取配置文件的输入流 (选那个)
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            //2.再使用SqlSessionFactoryBuild来build 输入流获取sqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取会话
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
