package com.dao.Mybatis.mapper;

import com.dao.Mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    public void deleteUserById(@Param("id") int id);

    public User findAdminById(@Param(value = "id")Integer id);

    public User findAdminByNameAndPassword(@Param(value = "name")String name,@Param(value = "password")String password);

    public List<User> findAllUser();

    public void changeUser(User user);
}
