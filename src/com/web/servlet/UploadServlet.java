package com.web.servlet;

import com.dao.Mybatis.pojo.Comment;
import com.service.CommentService;
import com.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    CommentService commentService = new CommentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        Part part = req.getPart("fileUpload");
        Comment comment = new Comment();
        String textComment = req.getParameter("textComment");
        //获取传入的文件名
        String submittedFileName = part.getSubmittedFileName();
        String username =( String) req.getSession().getAttribute("username");

        //进行非空校验，输入的评论为空时，也没有上传图片时 直接返回评论页面
        if(textComment==null||"".equals(textComment)&&(submittedFileName==null||"".equals(submittedFileName))){
            req.getRequestDispatcher("/comment").forward(req,resp);
            return;
        }else if(submittedFileName.toLowerCase().endsWith(".jpg")||
             submittedFileName.toLowerCase().endsWith(".png")){
            //获取存储的路径
            String realPath = getServletContext().getRealPath("/img/commentImg");
            System.out.println("getServletContext().getRealPath==="+realPath);
            //创建file对象
            File file = new File(realPath);

            //如果文件夹不存在则创建文件夹
            if(!file.exists()){
                file.mkdirs();
            }
            //为保存的图片设置名字
            String fileName = UUID.randomUUID().toString().replaceAll("-","")+
                    part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
            part.write(realPath + "/" + fileName);
            //删除临时文件
            part.delete();
            req.setAttribute("message",part.getSubmittedFileName() + "上传成功");

            //用户添加的文件是.jpg，.png图片时。将文件名保存到数据库
            comment.setPicture(fileName);
            comment.setUsername(username);
            comment.setTextComment(textComment);
        }else {
            comment.setUsername(username);
            comment.setTextComment(textComment);
        }
        commentService.addComment(comment);
        req.getRequestDispatcher("/comment").forward(req,resp);
    }

}
