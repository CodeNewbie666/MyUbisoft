package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.dao.Mybatis.pojo.Vip;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeUser")
public class ChangeUserServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Vip vip = new Vip();
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");
        String status = req.getParameter("status");
        System.out.println("status= "+status);

        if ("1".equals(status)){
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            //req.setAttribute("user",user);
            adminService.changeUser(user);
        }else if("2".equals(status)){
            vip.setId(id);
            vip.setUsername(username);
            vip.setPassword(password);
            vip.setPhoneNumber(phoneNumber);
            //req.setAttribute("user",user);
            adminService.changeVip(vip);
        }
        req.getRequestDispatcher("/userList").forward(req,resp);
    }
}
