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

/**
 * 该servlet用来校验用户名是否存在
 * 根据用户注册的类型，分别去 普通用户表和vip表进行查询，查看用户名是否存在
 * 对应作用在注册用户模块
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet{
    UserService userService = new UserServiceImpl();
    VipService vipService = new VipServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String status = req.getParameter("status");
        System.out.println("================false=======");
        Object exist = null;
        if ("1".equals(status)) {
            exist = userService.userNamecheck(username);
        }else if ("2".equals(status)){
            exist = vipService.findVipByName(username);
        }

        if (exist!=null){
            System.out.println("true");
            resp.getWriter().write("true");
        }else {
            System.out.println("false");
            resp.getWriter().write("false");
        }
    }
}
