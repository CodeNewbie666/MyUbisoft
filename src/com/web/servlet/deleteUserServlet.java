package com.web.servlet;

import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

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
        Integer id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        adminService.deleteUserById(id);

        //删除后返回到查询全部用户页面
        req.getRequestDispatcher("/userList").forward(req,resp);
    }
}
