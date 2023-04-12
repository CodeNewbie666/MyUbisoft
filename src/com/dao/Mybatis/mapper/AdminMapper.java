package com.dao.Mybatis.mapper;

import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    public void deleteUserById(@Param(value = "id") String id,@Param(value = "status")String status);

    public User findAdminById(@Param(value = "id")Integer id);

    public User findAdminByNameAndPassword(@Param(value = "name")String name,@Param(value = "password")String password);

    public List<User> findAllUser();

    public List<Vip> findAllVip();

    public void changeUser(User user);

    public void changeVip(Vip vip);
}
