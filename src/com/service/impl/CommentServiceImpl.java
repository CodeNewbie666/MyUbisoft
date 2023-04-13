package com.service.impl;

import com.dao.Mybatis.mapper.CommentMapper;
import com.dao.Mybatis.mapper.UserMapper;
import com.dao.Mybatis.pojo.Comment;
import com.service.CommentService;
import com.until.MybatisUntil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private static SqlSession sqlSession = MybatisUntil.getSqlSession();
    private static CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);

    @Override
    public void addComment(Comment comment) {
        mapper.addComment(comment);
        sqlSession.commit();
    }

    @Override
    public List<Comment> getAllComment() {
        return mapper.getAllComment();
    }
}
