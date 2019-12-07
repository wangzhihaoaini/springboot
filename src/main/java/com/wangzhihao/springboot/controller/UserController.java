package com.wangzhihao.springboot.controller;

import com.wangzhihao.springboot.entity.Result;
import com.wangzhihao.springboot.entity.User;
import com.wangzhihao.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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


    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request){
        User user = userService.login(username, password);
        if(user!=null){
            request.getSession().setAttribute("user",username);
            return new Result(true,"登陆成功");
        }else {
            return new Result(false,"用户名密码错误或用户不存在");
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
