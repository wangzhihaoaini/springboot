package com.wangzhihao.springboot.controller;

import com.wangzhihao.springboot.entity.Result;
import com.wangzhihao.springboot.entity.User;
import com.wangzhihao.springboot.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LoginController
 * @Description login
 * @Author wangzhihao
 * @Date 19/10/23 20:45
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String toLogin(@CookieValue(name = "username",required = false) String username,
                          @CookieValue(name = "password",required = false) String password,
                          Model model){
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request,HttpServletResponse response){
        // 从SecurityUtils里边创建一个 subject
        Subject subject= SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌)
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        // 执行认证登陆
        try {
            subject.login(token);
        }catch (Exception e) {
            return new Result(false,e.getMessage());
        }
        if(subject.isAuthenticated()){
            Cookie usernameCookie=new Cookie("username",username);
            Cookie passwordCookie=new Cookie("password",password);
            usernameCookie.setMaxAge(1000);
            passwordCookie.setMaxAge(1000);
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
            token.clear();
            return new Result(true,"登陆成功");
        }else{
            return new Result(false,"登陆失败");
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(User user){
        System.out.println(user);
        if(userService.queryOneByUsername(user.getUsername())!=null){
            return new Result(false,"此用户名已被注册");
        }
        Integer row = userService.insertOne(user);
        System.out.println(row);
        if(row>0){
            return new Result(true,"注册成功,请登录");
        }else {
            return new Result(false,"注册失败,请稍后重试");
        }
    }

    @GetMapping("/user")
    @ResponseBody
    public User queryOne(@RequestParam("username") String username, @RequestParam("password") String password){
        return this.userService.login(username,password);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public Integer deleteOne(@PathVariable("id") Integer id){
        return this.userService.deleteOne(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public Integer insertOne(User user){
        return this.userService.insertOne(user);
    }

    @PutMapping("/user")
    @ResponseBody
    public User updateOne(User user){
        return this.userService.updateOne(user);
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> queryAll(@RequestParam(value="username",required = false) String username,
                               @RequestParam(value="password",required = false) String password){
        return userService.queryAll(username,password);
    }
}
