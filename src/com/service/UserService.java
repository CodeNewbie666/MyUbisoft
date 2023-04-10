package com.service;

import com.dao.Mybatis.mapper.UserMapper;
import com.dao.Mybatis.pojo.User;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public User loginService(String username,String password){
        SqlSession sqlSession = MybatisUntil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

       return mapper.findUserByAndPassword(username, password);
    }
}
