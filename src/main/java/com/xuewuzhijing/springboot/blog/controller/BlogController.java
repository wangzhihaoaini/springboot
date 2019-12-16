package com.xuewuzhijing.springboot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping("/main")
    public String main(){
        return "blog/index/main";
    }

    @GetMapping("/open/page/about")
    public String about(){
        return "blog/index/about";
    }
}
