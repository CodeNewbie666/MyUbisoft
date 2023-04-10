package com.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 对管理用户页面进行校验，防止非admin用户进入管理页面
 */
@WebFilter(urlPatterns = "/zwy/manage.jsp")
public class manangerFilter implements Filter {
     @Override
     public void init(FilterConfig filterConfig) throws ServletException {

     }

     @Override
     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
             HttpServletRequest req = (HttpServletRequest)servletRequest;
             HttpSession session = req.getSession();

             //在这里处理过滤逻辑
             Object username = session.getAttribute("username");
             if (username==null||!username.equals("admin")){
                 servletRequest.getRequestDispatcher("/zwy/login.jsp").forward(servletRequest,servletResponse);
                 servletResponse.getWriter().write("非法访问");
             }else {
                 filterChain.doFilter(servletRequest,servletResponse);
             }
     }

     @Override
     public void destroy() {

     }
}
