package com.wangzhihao.springboot.blog.service.impl;

import com.wangzhihao.springboot.blog.entity.Comment;
import com.wangzhihao.springboot.blog.mapper.CommentMapper;
import com.wangzhihao.springboot.blog.service.CommentService;
import com.wangzhihao.springboot.common.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/30 13:52
 * @Version 1.0
 **/
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public Integer addComment(Integer articleId, String comment, String userNiakName){
        return this.commentMapper.addComment(articleId,comment,userNiakName);
    }

    @Override
    public List<Comment> queryAllById(Integer articleId) {
        return this.commentMapper.queryAllById(articleId);
    }
}
