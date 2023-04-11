package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import com.service.AdminService;
import com.service.UserService;
import com.service.VipService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UserServiceImpl;
import com.service.impl.VipServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/userList"})
public class userListService extends HttpServlet {
    UserService userService = new UserServiceImpl();
    VipService vipService = new VipServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> user = userService.findAllUser();
        List<Vip>  Vips = vipService.findAllVip();
        List<Object> allUsers = new ArrayList<>();
        allUsers.addAll(user);
        allUsers.addAll(Vips);
        //将查询出来的全部用户数据转发到前端页面
        req.setAttribute("allUsers",allUsers);
        req.getRequestDispatcher("/zwy/userlist.jsp").forward(req,resp);
    }
}
