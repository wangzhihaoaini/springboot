package com.xuewuzhijing.springboot.blog.mapper;


import com.xuewuzhijing.springboot.blog.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description
 * @Author xuewuzhijing
 * @Date 19/11/18 22:14
 * @Version 1.0
 **/
@Mapper
public interface ArticleMapper{
    List<Article> queryAll();
    Article openArticle(@Param("id") Integer id);
}
