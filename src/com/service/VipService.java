package com.service;

import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VipService {
    public Vip findVipByNameAndPassword(String username, String password);

    public Vip findVipByName(String username);

    public Vip findVipById(Integer id);

    public List<Vip> findAllVip();

    public void addVip(String username,String password, String phoneNumber);

    public void updateVip(User user);

    public void deleteVipById(Integer id);
}
