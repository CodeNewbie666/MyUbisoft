package com.service;

import com.dao.Mybatis.pojo.User;

import java.util.List;

public interface AdminService {
    public void deleteUserById(int id);

    //public void deleteChooseUsers();
    public User findAdminById(Integer id);

    public User findAdminByNameAndPassword(String name,String password);

    public List<User> findAllUser();

    public void changeUser(User user);
}
