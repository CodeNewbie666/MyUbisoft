package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@WebServlet("/changeUser")
public class ChangeUserServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        String username = req.getParameter("username");

        //因为请求传入的参数中有中文，所以得进行转码处理

        String password = req.getParameter("password");
        System.out.println(password);
        String phoneNumber = req.getParameter("phoneNumber");
        System.out.println(phoneNumber);

        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        req.setAttribute("user",user);
        adminService.changeUser(user);
        req.getRequestDispatcher("/userList").forward(req,resp);
    }
}
