package com.wangzhihao.springboot.blog.controller;

import com.wangzhihao.springboot.blog.entity.Article;
import com.wangzhihao.springboot.blog.entity.Comment;
import com.wangzhihao.springboot.blog.service.BlogService;
import com.wangzhihao.springboot.blog.service.CommentService;
import com.wangzhihao.springboot.common.controller.BaseController;
import com.wangzhihao.springboot.system.entity.User;
import com.wangzhihao.springboot.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private CommentService commentService;

    @GetMapping("/main")
    public String main(Model model){
        List<Article> articles = blogService.queryAll();
        model.addAttribute("articles",articles);
        return "blog/index/main";
    }

    @GetMapping("/article/{id}")
    public String openArticle(@PathVariable("id") Integer id,Model model){
        Article article = blogService.openArticle(id);
        List<Comment> comments = commentService.queryAllById(id);
        model.addAttribute("article",article);
        model.addAttribute("comments",comments);
        return "blog/content/article";
    }

    @PostMapping("/article")
    public String addArticle(Model model){
        User user = (User) this.getSubject().getPrincipal();
        model.addAttribute("nickname",user.getNickName());
        return "blog/content/add";
    }

    @GetMapping("/articles")
    public String bContent(){
        return "blog/content/content";
    }

    @GetMapping("/about")
    public String about(){
        return "blog/index/about";
    }
}
