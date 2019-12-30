package com.wangzhihao.springboot.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/27 16:11
 * @Version 1.0
 **/
@Controller
public class IndexController {
    /**
    *@Author wangzhihao
    *@Description 输入网址时重定向到博客首页
    *@Date 16:13 2019/12/27
    *@Param []
    *@return java.lang.String
    **/
    @GetMapping("/")
    public String toBlogMain(){
        return  "redirect:/blog/main";
    }
}
