package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.service.AdminService;
import com.service.UserService;
import com.service.VipService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.UserServiceImpl;
import com.service.impl.VipServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 对用户登录进行校验，普通用户登录成功进入主页，管理员的话进行用户管理页面
 */
@WebServlet(urlPatterns = "/loginCheck")
public class LoginServlet extends HttpServlet{
    AdminService adminService = new AdminServiceImpl();
    UserService userService = new UserServiceImpl();
    VipService vipService = new VipServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // String username = new String(req.getParameter("username").getBytes("iso-8859-1"), "utf-8");

        String username = req.getParameter("username");
        System.out.println("用户名："+username);
        String password = req.getParameter("password");
        System.out.println("密码："+password);
        String status = req.getParameter("status");

        if (username==null||"".equals(username)||password==null||"".equals(password)){
            req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
        }

        System.out.println(status);
        //根据不同的用户类型，去对应的表中查询用户名和密码是否存在
        switch (status){
            case "0":   //查询该管理员是否存在，存在进入管理员页面
                if (adminService.findAdminByNameAndPassword(username,password)!=null){
                   addCookie(req,resp,username,password);
                    req.getRequestDispatcher("/userList?currentPage=1").forward(req,resp);
                }else req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
                break;

            case "1"://普通用户进入主页
                if (userService.findVipByNameAndPassword(username,password)!=null){
                    addCookie(req,resp,username,password);
                    req.getRequestDispatcher("/index.jsp").forward(req,resp);
                }else req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
                break;

            case "2":  //进入会员页面
                if (vipService.findVipByNameAndPassword(username,password)!=null){
                    addCookie(req,resp,username,password);
                    req.getRequestDispatcher("/comment").forward(req,resp);
                }else req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
                break;

            default: //防止用户非法传参，直接进入失败页面
                req.getRequestDispatcher("/zwy/loginfail.jsp").forward(req,resp);
        }
    }

        //保存登录的用户的session和向浏览器发送Cookie
    public void addCookie(HttpServletRequest req,HttpServletResponse resp,String username,String password){
        HttpSession session = req.getSession();
        session.setAttribute("username",username);
        session.setAttribute("password",password);

        resp.addCookie(new Cookie("username",username));
        resp.addCookie(new Cookie("password",password));
    }
}
