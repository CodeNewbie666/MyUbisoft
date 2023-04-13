package com.dao.Mybatis.mapper;

import com.dao.Mybatis.pojo.Comment;

import java.util.List;

public interface CommentMapper {
    public List<Comment> getAllComment();

    public void addComment(Comment comment);
}
