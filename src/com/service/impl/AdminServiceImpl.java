package com.service.impl;

import com.dao.Mybatis.mapper.AdminMapper;
import com.dao.Mybatis.mapper.UserMapper;
import com.dao.Mybatis.pojo.User;
import com.service.AdminService;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private static SqlSession sqlSession = MybatisUntil.getSqlSession();
    private static AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

    @Override
    public void deleteUserById(int id) {
        mapper.deleteUserById(id);
        sqlSession.commit();
    }

    @Override
    public User findAdminByNameAndPassword(String name, String password) {
        return mapper.findAdminByNameAndPassword(name,password);
    }

    @Override
    public User findAdminById(Integer id) {
        return mapper.findAdminById(id);
    }

    @Override
    public List<User> findAllUser() {
        return mapper.findAllUser();
    }

    @Override
    public void changeUser(User user) {
        mapper.changeUser(user);
        sqlSession.commit();
    }
}
