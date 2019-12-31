package com.wangzhihao.springboot.blog.service;

import com.wangzhihao.springboot.blog.entity.Comment;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/30 13:50
 * @Version 1.0
 **/
public interface CommentService{
    Integer addComment(Integer articleId,String comment,String userNiakName);
    List<Comment> queryAllById(Integer articleId);
}
