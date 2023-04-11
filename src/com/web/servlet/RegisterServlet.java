package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.service.UserService;
import com.service.VipService;
import com.service.impl.UserServiceImpl;
import com.service.impl.VipServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    VipService vipService = new VipServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        Integer status = Integer.parseInt(req.getParameter("status"));

        //进行注册类型判断,1的话为普通用户，2为会员
        if (status==1){
            userService.addUser(username,password,phone);
            req.getSession().setAttribute("username" ,username);
        }else if (status==2){
            vipService.addVip(username,password,phone);
            req.getSession().setAttribute("username" ,username);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/zwy/login.jsp");
        }
       /* User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhoneNumber(phone);

        //添加到数据库
        userService.addUser(username,password,phone);*/
    }
}
