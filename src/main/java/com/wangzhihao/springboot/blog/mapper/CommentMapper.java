package com.wangzhihao.springboot.blog.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @ClassName CommentMapper
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/30 16:13
 * @Version 1.0
 **/
@Mapper
public interface CommentMapper{
    void addComment(@Param("articleId") Integer articleId,@Param("comment") String comment,@Param("userNiakName") String userNiakName,@Param("date") Date date);
}
