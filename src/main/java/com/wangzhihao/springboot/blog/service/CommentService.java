package com.wangzhihao.springboot.blog.service;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/30 13:50
 * @Version 1.0
 **/
public interface CommentService{
    void addComment(Integer articleId,String comment,String userNiakName);
}
