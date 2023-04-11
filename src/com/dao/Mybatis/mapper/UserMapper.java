package com.dao.Mybatis.mapper;

import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //查询用户是否存在，进行登录验证
    public User findUserByIdAndPassword(@Param(value = "username")String username,@Param(value = "password") String password);

    public User findUserByName(@Param(value = "username")String username);

    public User findUserById(@Param(value = "id")Integer id);

    public List<User> findAllUser();

    public void addUser(@Param(value = "username")String username,@Param(value = "password") String password,
                        @Param(value = "phoneNumber") String phoneNumber);

    public void updateUser(User user);
}
