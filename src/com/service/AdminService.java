package com.service;

import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import com.dao.Mybatis.pojo.PageBean;

import java.util.List;

public interface AdminService {
    public void deleteUserById(String id,String status);

    //public void deleteChooseUsers();
    public User findAdminById(Integer id);

    public User findAdminByNameAndPassword(String name,String password);

    public List<Object> findAll();

    public List<User> findAllUser();

    public List<Vip> findAllVip();

    public PageBean findUserByPage(int currentPage, int rows );

    public void changeUser(User user);

    public void changeVip(Vip vip);
}
