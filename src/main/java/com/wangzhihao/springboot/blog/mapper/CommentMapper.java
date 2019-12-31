package com.wangzhihao.springboot.blog.mapper;

import com.wangzhihao.springboot.blog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CommentMapper
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/30 16:13
 * @Version 1.0
 **/
@Mapper
public interface CommentMapper{
    Integer addComment(@Param("articleId") Integer articleId,@Param("comment") String comment,@Param("userNiakName") String userNiakName);
    List<Comment> queryAllById(@Param("articleId") Integer articleId);
}
