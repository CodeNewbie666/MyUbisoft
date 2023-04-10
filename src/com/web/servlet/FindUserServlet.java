package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet{
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain;charset=utf-8");
        String username = req.getParameter("username");
        System.out.println(username);
        User user = userService.userNamecheck(username);
        System.out.println(user);
        if (user!=null){
            System.out.println("true");
            resp.getWriter().write("true");
        }else {
            System.out.println("false");
            resp.getWriter().write("false");
        }
    }
}
