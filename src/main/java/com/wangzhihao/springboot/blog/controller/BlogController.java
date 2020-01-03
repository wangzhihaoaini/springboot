package com.wangzhihao.springboot.blog.controller;

import com.wangzhihao.springboot.blog.entity.Article;
import com.wangzhihao.springboot.blog.entity.Comment;
import com.wangzhihao.springboot.blog.service.BlogService;
import com.wangzhihao.springboot.blog.service.CommentService;
import com.wangzhihao.springboot.common.controller.BaseController;
import com.wangzhihao.springboot.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
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
    private CommentService commentService;

    /**
    *@Author wangzhihao
    *@Description 博客主页
    *@Date 10:01 2020/1/2
    *@Param [model]
    *@return java.lang.String
    **/
    @GetMapping("/main")
    public String main(Model model){
        List<Article> articles = blogService.queryAll();
        model.addAttribute("articles",articles);
        return "blog/index/main";
    }

    /**
    *@Author wangzhihao
    *@Description 查看文章
    *@Date 10:01 2020/1/2
    *@Param [id, model]
    *@return java.lang.String
    **/
    @GetMapping("/article/{id}")
    public String openArticle(@PathVariable("id") Integer id,Model model){
        Article article = blogService.openArticle(id);
        List<Comment> comments = commentService.queryAllById(id);
        model.addAttribute("article",article);
        model.addAttribute("comments",comments);
        return "blog/content/article";
    }

    /**
    *@Author wangzhihao
    *@Description 文章添加页面
    *@Date 10:06 2020/1/2
    *@Param []
    *@return java.lang.String
    **/
    @GetMapping("/article")
    public String toArticleAdd(){
        return "blog/content/add";
    }

    /**
    *@Author wangzhihao
    *@Description 添加文章
    *@Date 10:01 2020/1/2
    *@Param [model]
    *@return java.lang.String
    **/
    @PostMapping("/article")
    @ResponseBody
    public Object addArticle(@RequestParam("title") String title,@RequestParam("content") String content,
                             @RequestParam("type") String type,@RequestParam(name = "allowComment",required = false) boolean allowComment,
                             @RequestParam(name = "allowFeed",required = false) boolean allowFeed,@RequestParam("status") Integer status){
        User user = (User) this.getSubject().getPrincipal();
        if(user==null){
            return this.ajaxFail("请先登录");
        }
        Integer integer = this.blogService.addArticle(title, content, type, allowComment, allowFeed, user.getNickName(), user.getId(),status);
        System.out.println(integer);
        return this.ajaxSuccess("发表成功");
    }

    /**
    *@Author wangzhihao
    *@Description 查看所有文章
    *@Date 10:01 2020/1/2
    *@Param []
    *@return java.lang.String
    **/
    @GetMapping("/articles")
    public String bContent(){
        return "all";
    }


    /**
    *@Author wangzhihao
    *@Description 关于我们
    *@Date 10:01 2020/1/2
    *@Param []
    *@return java.lang.String
    **/
    @GetMapping("/about")
    public String about(){
        return "blog/index/about";
    }
}
