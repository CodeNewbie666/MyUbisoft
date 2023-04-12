package com.web.servlet;

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

@WebServlet("/deleteUser")
public class deleteUserServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        int status = Integer.parseInt( req.getParameter("status"));
        String id = req.getParameter("id");
        String status = req.getParameter("status");

        //根据status来判断是普通用户表里面的还是vip表里面的
        adminService.deleteUserById(id,status);
        //删除后返回到查询全部用户页面
        req.getRequestDispatcher("/userList").forward(req,resp);
    }
}
