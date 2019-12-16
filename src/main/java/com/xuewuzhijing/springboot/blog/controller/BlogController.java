package com.xuewuzhijing.springboot.blog.controller;

import com.xuewuzhijing.springboot.blog.entity.Article;
import com.xuewuzhijing.springboot.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName BlogController
 * @Description TODO
 * @Author xuewuzhijing
 * @Date 2019/12/16 14:10
 * @Version 1.0
 **/
@Controller
@RequestMapping("/blog")
public class BlogController{
    @Autowired
    private BlogService blogService;

    @GetMapping("/main")
    public String main(Model model){
        List<Article> articles = blogService.queryAll();
        for (Article article:articles
             ) {
            System.out.println(article);
        }
        model.addAttribute("articles",articles);
        return "blog/index/main";
    }

    @GetMapping("/open/page/about")
    public String about(){
        return "blog/index/about";
    }
}
