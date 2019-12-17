package com.xuewuzhijing.springboot.blog.service.impl;

import com.xuewuzhijing.springboot.blog.entity.Article;
import com.xuewuzhijing.springboot.blog.mapper.ArticleMapper;
import com.xuewuzhijing.springboot.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BlogServiceImpl
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/16 15:52
 * @Version 1.0
 **/
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> queryAll() {
        return this.articleMapper.queryAll();
    }

    @Override
    public Article openArticle(Integer id) {
        return this.articleMapper.openArticle(id);
    }
}
