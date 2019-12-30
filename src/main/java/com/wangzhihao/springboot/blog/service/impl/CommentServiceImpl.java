package com.wangzhihao.springboot.blog.service.impl;

import com.wangzhihao.springboot.blog.mapper.CommentMapper;
import com.wangzhihao.springboot.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
    public void addComment(Integer articleId, String comment, String userNiakName){
//        this.commentMapper.addComment(articleId,comment,userNiakName,new LocalDateTime.now());
    }
}
