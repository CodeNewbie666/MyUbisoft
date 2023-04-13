package com.web.servlet;

import com.dao.Mybatis.pojo.Comment;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/comment")
public class commentListServlet extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //对所有评论进行读取，然后发送到浏览器
        List<Comment> allComment = commentService.getAllComment();
        req.setAttribute("allComment",allComment);
        req.getRequestDispatcher("/zwy/comment.jsp").forward(req,resp);
    }
}
