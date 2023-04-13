package com.web.servlet;

import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 该servlet用来删除管理员选中的用户
 */
@WebServlet(urlPatterns = "/deleteSelect")
public class deleteSelectServlet extends HttpServlet {
    AdminService adminService = new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //将用户的id和账号类型以请求过来，然后根据不同账号类型去对应的表去删除
        String[] idAndStatus = req.getParameterValues("IdAndStatus");

        //遍历删除选中的用户
        for (String andStatus : idAndStatus) {
            String[] split = andStatus.split(",");
            adminService.deleteUserById(split[0],split[1]);
        }
        //删除完毕后，重新查询全部用户，然后返回前端页面
        req.getRequestDispatcher("/userList").forward(req,resp);
    }
}
