package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.service.AdminService;
import com.service.UserService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 对用户登录进行校验，普通用户登录成功进入主页，管理员的话进行用户管理页面
 */
@WebServlet(urlPatterns = "/loginCheck")
public class LoginServlet extends HttpServlet{
    UserService userService = new UserServiceImpl();
    AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
       // String username = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");

        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        String status = req.getParameter("status");

        if (username==null||"".equals(username)||password==null||"".equals(password)){
            req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
        }
        //查询用户是否存在
        /*User user = userService.loginService(username, password);
        System.out.println(user);

        if (user!=null){
            //登录成功后，将用户信息放入session中
          HttpSession session = req.getSession();
          session.setAttribute("username",username);
          session.setAttribute("password",password);

          //如果登录的是管理员则转发到用户管理页面
          if ("admin".equals(user.getUsername())){
              req.getRequestDispatcher("/userList").forward(req,resp);
          }else {
              req.getRequestDispatcher("/index.jsp").forward(req,resp);
          }
        }else {
            req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
        }*/
        switch (status){
            case "0":   //查询该管理员是否存在，存在进入管理员页面
                if (adminService.findAdminByNameAndPassword(username,password)!=null){
                    addCookie(req,resp,username,password);
                    req.getRequestDispatcher("/userList").forward(req,resp);
                }else req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
                break;

            case "1":
                break;

            case "2":  //进入会员页面
                if (userService.findUserByIdAndPassword(username,password)!=null){
                    addCookie(req,resp,username,password);
                    req.getRequestDispatcher("/index.jsp").forward(req,resp);
                }else req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
                break;

            default: //防止用户非法传参，直接进入失败页面
                req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
        }
    }

    public void addCookie(HttpServletRequest req,HttpServletResponse resp,String username,String password){
        HttpSession session = req.getSession();
        session.setAttribute("username",username);

        resp.addCookie(new Cookie("username",username));
        resp.addCookie(new Cookie("password",password));
    }
}
