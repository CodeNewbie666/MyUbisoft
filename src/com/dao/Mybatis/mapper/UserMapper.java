package com.dao.Mybatis.mapper;

import com.dao.Mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //查询用户是否存在，进行登录验证
    public User findUserByAndPassword(@Param(value = "name") String name, @Param(value = "password") String password);
}
