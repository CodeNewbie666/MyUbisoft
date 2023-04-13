package com.web.servlet;

import com.dao.Mybatis.pojo.PageBean;
import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 该servetl用来查询全部的普通用户和会员用户
 * 进行分页显示
 */
@WebServlet(urlPatterns = {"/userList"})
public class userListService extends HttpServlet {
    AdminService adminService =new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前是第几页
        String currentPage_ = req.getParameter("currentPage");
        if (currentPage_==null|| currentPage_.equals("")){
            currentPage_="1";
        }

        int currentPage = Integer.parseInt(currentPage_);
        //每页显示6条
        int rows = 6;
        PageBean pageBean = adminService.findUserByPage(currentPage, rows);
        System.out.println(pageBean);

        //将查询出来的全部用户数据转发到前端页面
        req.setAttribute("pageBean",pageBean);
        req.getRequestDispatcher("/zwy/userlist.jsp").forward(req,resp);
    }
}
