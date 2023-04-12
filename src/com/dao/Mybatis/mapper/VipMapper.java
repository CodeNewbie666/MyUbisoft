package com.dao.Mybatis.mapper;

import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VipMapper {
    public Vip findVipByIdAndPassword(@Param(value = "username")String username, @Param(value = "password") String password);

    public Vip findVipByName(@Param(value = "username")String username);

    public Vip findVipById(@Param(value = "id")Integer id);

    public List<Vip> findAllVip();

    public void addVip(@Param(value = "username")String username,@Param(value = "password") String password,
                        @Param(value = "phoneNumber") String phoneNumber);

    public void updateVip(User user);

    public void deleteVipById(@Param(value = "id")Integer id);
}
