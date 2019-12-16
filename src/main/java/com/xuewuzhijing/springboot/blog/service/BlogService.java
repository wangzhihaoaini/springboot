package com.xuewuzhijing.springboot.blog.service;

import com.xuewuzhijing.springboot.blog.entity.Article;

import java.util.List;

/**
 * @ClassName BlogService
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/16 15:51
 * @Version 1.0
 **/
public interface BlogService{
    List<Article> queryAll();
}
