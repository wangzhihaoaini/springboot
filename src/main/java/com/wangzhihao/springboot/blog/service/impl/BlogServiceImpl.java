package com.wangzhihao.springboot.blog.service.impl;

import com.wangzhihao.springboot.blog.entity.Article;
import com.wangzhihao.springboot.blog.mapper.ArticleMapper;
import com.wangzhihao.springboot.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
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
    public List<Article> queryAllArticle() {
        return this.articleMapper.queryAllArticle();
    }

    @Override
    public Article openArticle(Integer id) {
        return this.articleMapper.openArticle(id);
    }

    @Override
    public Integer addArticle(String title, String content, String type, boolean allowComment, boolean allowFeed, String author,Integer authorId,Integer status) {
            return this.articleMapper.addArticle(title,content,type,allowComment,allowFeed,author,authorId,status);
    }

}
