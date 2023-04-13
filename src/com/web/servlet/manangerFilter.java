package com.web.servlet;

import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 对管理用户页面进行校验，防止非admin用户进入管理页面
 */
@WebFilter(urlPatterns = {"/zwy/manage.jsp","/zwy/userlist.jsp","/zwy/changeuser.jsp"})
public class manangerFilter implements Filter {
     AdminService adminService = new AdminServiceImpl();
     @Override
     public void init(FilterConfig filterConfig) throws ServletException {

     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         HttpServletRequest req = (HttpServletRequest)servletRequest;
         HttpSession session = req.getSession();
         //获取登录时保存的用户名和密码，用于校验是是否是管理员账号
         String username =(String) session.getAttribute("username");
         String password =(String) session.getAttribute("password");

         //在这里处理过滤逻辑，非管理员用户登录时禁止访问用户管理页面
         if (username==null||password==null||adminService.findAdminByNameAndPassword(username,password)==null){
             servletRequest.getRequestDispatcher("/zwy/login.jsp").forward(servletRequest,servletResponse);
         }else {
             filterChain.doFilter(servletRequest,servletResponse);
         }
     }

     @Override
     public void destroy() {

     }
}
