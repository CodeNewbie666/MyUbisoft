package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phone);

        //添加到数据库
        userService.addUser(username,password,phone);

        //注册成功后进入登录页面
        req.getSession().setAttribute("username" ,username);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
