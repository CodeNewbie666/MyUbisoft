package com.web.servlet;

import com.dao.Mybatis.mapper.UserMapper;
import com.dao.Mybatis.pojo.User;
import com.service.UserService;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 对用户登录进行校验，普通用户登录成功进入主页，管理员的话进行用户管理页面
 */
@WebServlet(urlPatterns = "/loginCheck")
public class LoginServlet extends HttpServlet{
    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username==null||"".equals(username)||password==null||"".equals(password)){
            req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
        }
        //查询用户是否存在
        User user = userService.loginService(username, password);
        if (user!=null){
            //登录成功后，将用户信息放入session中
          HttpSession session = req.getSession();
          session.setAttribute("username",username);
          session.setAttribute("password",password);
          req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
        }

    }
}
