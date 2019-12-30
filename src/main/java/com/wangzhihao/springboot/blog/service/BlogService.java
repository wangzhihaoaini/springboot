package com.wangzhihao.springboot.blog.service;

import com.wangzhihao.springboot.blog.entity.Article;

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
    Article openArticle(Integer id);
}
