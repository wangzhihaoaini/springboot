package com.wangzhihao.springboot.blog.mapper;


import com.wangzhihao.springboot.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description
 * @Author wangzhihao
 * @Date 19/11/18 22:14
 * @Version 1.0
 **/
@Mapper
public interface ArticleMapper{
    List<Article> queryAll();
    Article openArticle(@Param("id") Integer id);
}
