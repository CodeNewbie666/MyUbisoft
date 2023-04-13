package com.service.impl;

import com.dao.Mybatis.mapper.AdminMapper;
import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import com.dao.Mybatis.pojo.PageBean;
import com.service.AdminService;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private static SqlSession sqlSession = MybatisUntil.getSqlSession();
    private static AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);

    @Override
    public void deleteUserById(String id,String status) {
        mapper.deleteUserById(id,status);
        sqlSession.commit();
    }

    @Override
    public User findAdminByNameAndPassword(String name, String password) {
        return mapper.findAdminByNameAndPassword(name,password);
    }

    @Override
    public User findAdminById(Integer id) {
        return mapper.findAdminById(id);
    }

    public List<Object> findAll(){
        List<User> allUser = mapper.findAllUser();
        List<Vip> allVip = mapper.findAllVip();
        List<Object> allUsers = new ArrayList<>();

        allUsers.addAll(allUser);
        allUsers.addAll(allVip);

        return allUsers;
    }

    @Override
    public PageBean findUserByPage(int currentPage, int rows ) {
        List<Object> all = findAll();
        PageBean pageBean = new PageBean();
        int maxRow = all.size();
        int lastPageRow= maxRow%rows;
        int maxPage = lastPageRow==0?maxRow/rows:(maxRow/rows)+1;

        //直接对查询出来的全部数据进行局部获取，实现分页
        int start = (currentPage-1)*rows;

        //判断是否为最后一页, 最后一页获取比较特殊
        int end = currentPage==maxPage? (start+lastPageRow):(start+rows);
        List<Object> currentList= all.subList(start,end);

        pageBean.setMaxrow(all.size());
        pageBean.setMaxPage(maxPage);
        pageBean.setRow(rows);
        pageBean.setCurrentPage(currentPage);
        pageBean.setCurrentList(currentList);

        return pageBean;
    }

    @Override
    public List<User> findAllUser() {
        return mapper.findAllUser();
    }

    @Override
    public List<Vip> findAllVip() {
        return mapper.findAllVip();
    }

    @Override
    public void changeUser(User user) {
        mapper.changeUser(user);
        sqlSession.commit();
    }

    @Override
    public void changeVip(Vip vip) {
        mapper.changeVip(vip);
        sqlSession.commit();
    }
}
