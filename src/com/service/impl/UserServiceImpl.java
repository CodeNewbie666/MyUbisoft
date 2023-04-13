package com.service.impl;

import com.dao.Mybatis.mapper.UserMapper;
import com.dao.Mybatis.pojo.User;
import com.service.UserService;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static SqlSession sqlSession = MybatisUntil.getSqlSession();
    private static UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    public User findVipByNameAndPassword(String username,String password){
       return mapper.findVipByNameAndPassword(username, password);
    }

    public User userNamecheck(String username){
        return mapper.findUserByName(username);
    }

    public User findUserById(Integer id){
        return mapper.findUserById(id);
    }

    @Override
    public List<User> findAllUser() {
        return mapper.findAllUser();
    }

    public void addUser(String username,String password,String phoneNumber){
        mapper.addUser(username,password,phoneNumber);
        sqlSession.commit();
    }

    public void updateUser(User user){
        mapper.updateUser(user);
        sqlSession.commit();
    }
}
