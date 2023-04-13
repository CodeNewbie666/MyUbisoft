package com.web.servlet;

import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来删除单个用户
 */
@WebServlet("/deleteUser")
public class deleteUserServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String status = req.getParameter("status");

        //根据status来判断是普通用户表里面的还是vip表里面的
        adminService.deleteUserById(id,status);
        //删除后返回到查询全部用户页面
        req.getRequestDispatcher("/userList").forward(req,resp);
    }
}
