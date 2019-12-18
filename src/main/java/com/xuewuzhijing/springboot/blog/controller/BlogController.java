package com.xuewuzhijing.springboot.blog.controller;

import com.xuewuzhijing.springboot.blog.entity.Article;
import com.xuewuzhijing.springboot.blog.service.BlogService;
import com.xuewuzhijing.springboot.common.controller.BaseController;
import com.xuewuzhijing.springboot.system.entity.User;
import com.xuewuzhijing.springboot.system.service.UserService;
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
 * @Author wangzhihao
 * @Date 2019/12/16 14:10
 * @Version 1.0
 **/
@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController{
    @Autowired
    private BlogService blogService;
    @Autowired
    private UserService userService;

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
        return "blog/content/article";
    }

    @GetMapping("/content/add")
    public String addArticle(Model model){
        User user = (User) this.getSubject().getPrincipal();
        model.addAttribute("nickname",user.getNickName());
        return "blog/content/add";
    }

    @GetMapping("/content/all")
    public String bContent(){
        return "blog/content/content";
    }

    @GetMapping("/open/page/about")
    public String about(){
        return "blog/index/about";
    }
}
