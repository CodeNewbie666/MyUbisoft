package com.Test;

import com.dao.Mybatis.mapper.UserMapper;
import com.dao.Mybatis.pojo.User;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

public class test {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User aaa = mapper.findUserByAndPassword("aaa", "666");
        System.out.println(aaa);
    }
}
