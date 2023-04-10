package com.dao.Mybatis.mapper;

import com.dao.Mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //查询用户是否存在，进行登录验证
    public User findUserByIdAndPassword(@Param(value = "username") String name, @Param(value = "password") String password);

    public User findUserByName(@Param(value = "username")String username);

    public void addUser(@Param(value = "username")String username,@Param(value = "password") String password,
                        @Param(value = "phoneNumber") String phoneNumber);
}
