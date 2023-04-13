package com.service;

import com.dao.Mybatis.pojo.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> getAllComment();

    public void addComment(Comment comment);
}
