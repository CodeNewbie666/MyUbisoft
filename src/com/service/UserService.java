package com.service;

import com.dao.Mybatis.pojo.User;

import java.util.List;

public interface UserService {
    public User findVipByNameAndPassword(String username, String password);

    public User userNamecheck(String username);

    public User findUserById(Integer id);

    public List<User> findAllUser();

    public void addUser(String username,String password,String phoneNumber);

    public void updateUser(User user);
}
