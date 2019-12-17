package com.xuewuzhijing.springboot.system.controller;

import com.xuewuzhijing.springboot.common.controller.BaseController;
import com.xuewuzhijing.springboot.system.entity.Resource;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName LearnController
 * @Description thymeleaf测试controller
 * @Author xuewuzhijing
 * @Date 2019/9/25 22:48
 * @Version 1.0
 **/
@Controller
@RequiresPermissions("user:resource")
@RequestMapping("resource")
public class ResourceController extends BaseController{
    @RequestMapping("index")
    public ModelAndView index(){
        List<Resource> learnList =new ArrayList<Resource>();
        Resource bean =new Resource("官方参考文档","Spring Boot Reference Guide","http://docs.spring.io/spring-boot/docs/1.5.1.RELEASE/reference/htmlsingle/#getting-started-first-application");
        learnList.add(bean);
        bean =new Resource("官方SpriongBoot例子","官方SpriongBoot例子","https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples");
        learnList.add(bean);
        bean =new Resource("龙国学院","Spring Boot 教程系列学习","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new Resource("嘟嘟MD独立博客","Spring Boot干货系列 ","http://tengj.top/");
        learnList.add(bean);
        bean =new Resource("后端编程嘟","Spring Boot教程和视频 ","http://www.toutiao.com/m1559096720023553/");
        learnList.add(bean);
        bean =new Resource("程序猿DD","Spring Boot系列","http://www.roncoo.com/article/detail/125488");
        learnList.add(bean);
        bean =new Resource("纯洁的微笑","Sping Boot系列文章","http://www.ityouknow.com/spring-boot");
        learnList.add(bean);
        bean =new Resource("CSDN——小当博客专栏","Sping Boot学习","http://appjs.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new Resource("梁桂钊的博客","Spring Boot 揭秘与实战","http://appjs.csdn.net/column/details/spring-boot.html");
        learnList.add(bean);
        bean =new Resource("林祥纤博客系列","从零开始学Spring Boot ","http://412887952-qq-com.iteye.com/category/356333");
        learnList.add(bean);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

    @RequestMapping("game1")
    public String hello(){
        return "games/game1";
    }
}