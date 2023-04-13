package com.web.servlet;

import com.dao.Mybatis.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于用户修改自己的账号信息，如用户名，密码等
 */
@WebServlet(urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Integer id = (Integer)req.getSession().getAttribute("id");
        user.setId(id);
        User userById = userService.findUserById(id);
        System.out.println(userById);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");

        //用户未修改过的信息，就不需要进行更新了
        if(!username.equals(userById.getUsername())){
            user.setUsername(username);
            req.getSession().setAttribute("username",username);
        }
        if(!password.equals(userById.getPassword())){
            user.setPassword(password);
        }
        if (!phone.equals(userById.getPhoneNumber())){
            user.setPhoneNumber(phone);
        }
        //进行用户数据更新
        userService.updateUser(user);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
