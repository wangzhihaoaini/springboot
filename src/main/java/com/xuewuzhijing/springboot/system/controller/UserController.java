package com.xuewuzhijing.springboot.system.controller;

import com.xuewuzhijing.springboot.common.controller.BaseController;
import com.xuewuzhijing.springboot.system.entity.User;
import com.xuewuzhijing.springboot.system.service.UserService;

import java.util.List;

import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



/**
 * @ClassName LoginController
 * @Description login
 * @Author xuewuzhijing
 * @Date 19/10/23 20:45
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String toLogin(Model model){
        User user=(User)this.getSubject().getPrincipal();
        if(user!=null){
            model.addAttribute("username",user.getUsername());
            model.addAttribute("password",user.getPassword());
        }
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password,
                        @RequestParam(name = "rememberMe",required = false) boolean rememberMe){
        // 从BaseController继承的方法
        Subject subject=this.getSubject();
        // 在认证提交前准备 token（令牌)
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        // 执行认证登陆
        try {
            token.setRememberMe(rememberMe);
            subject.login(token);
        }catch (Exception e) {
            this.logger.error(e.getMessage());
            return this.ajaxFail(e.getMessage());
        }
        if(subject.isAuthenticated()){
            return this.ajaxSuccess("登陆成功");
        }else{
            token.clear();
            return this.ajaxFail("登陆失败");
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public Object register(User user){
        if(userService.queryOneByUsername(user.getUsername())!=null){
            return this.ajaxFail("此用户名已被注册");
        }
        Integer row = userService.insertOne(user);
        if(row>0){
            return this.ajaxSuccess("注册成功,请登录");
        }else {
            return this.ajaxFail("注册失败,请稍后重试");
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
