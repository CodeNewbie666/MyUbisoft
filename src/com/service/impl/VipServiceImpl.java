package com.service.impl;

import com.dao.Mybatis.mapper.VipMapper;
import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import com.service.VipService;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class VipServiceImpl implements VipService {
    private static SqlSession sqlSession = MybatisUntil.getSqlSession();
    private static VipMapper mapper = sqlSession.getMapper(VipMapper.class);

    @Override
    public Vip findVipByNameAndPassword(String username, String password) {
        return mapper.findVipByNameAndPassword(username,password);
    }

    public List<Vip> findAllVip(){
        return mapper.findAllVip();
    }

    @Override
    public Vip findVipByName(String username) {
        return mapper.findVipByName(username);
    }

    @Override
    public Vip findVipById(Integer id) {
        return mapper.findVipById(id);
    }

    @Override
    public void addVip(String username, String password, String phoneNumber) {
        mapper.addVip(username,password,phoneNumber);
        sqlSession.commit();
    }

    @Override
    public void updateVip(User user) {
        mapper.updateVip(user);
        sqlSession.commit();
    }

    @Override
    public void deleteVipById(Integer id) {
    }
}
