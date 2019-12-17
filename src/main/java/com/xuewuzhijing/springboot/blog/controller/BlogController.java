package com.xuewuzhijing.springboot.blog.controller;

import com.xuewuzhijing.springboot.blog.entity.Article;
import com.xuewuzhijing.springboot.blog.service.BlogService;
import com.xuewuzhijing.springboot.common.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class BlogController extends BaseController{
    @Autowired
    private BlogService blogService;

    @GetMapping("/main")
    public String main(Model model){
        List<Article> articles = blogService.queryAll();
        model.addAttribute("articles",articles);
        return "blog/index/main";
    }

    @GetMapping("/article/{id}")
    public String openArticle(@PathVariable("id") Integer id,Model model){
        Article article = blogService.openArticle(id);
        model.addAttribute("article",article);
        return "blog/bContent/article";
    }

    @GetMapping("/open/page/about")
    public String about(){
        return "blog/bContent/bContent";
    }
}
