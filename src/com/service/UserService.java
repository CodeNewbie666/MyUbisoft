package com.service;

import com.dao.Mybatis.mapper.UserMapper;
import com.dao.Mybatis.pojo.User;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    private static SqlSession sqlSession = MybatisUntil.getSqlSession();
    private static UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    public User loginService(String username,String password){
       return mapper.findUserByIdAndPassword(username, password);
    }

    public User userNamecheck(String username){
        return mapper.findUserByName(username);
    }

    public void addUser(String username,String password,String phoneNumber){
        mapper.addUser(username,password,phoneNumber);
        sqlSession.commit();
    }
}
