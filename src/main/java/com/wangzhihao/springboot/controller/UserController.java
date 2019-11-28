package com.wangzhihao.springboot.controller;

import com.wangzhihao.springboot.entity.User;
import com.wangzhihao.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Description 用户控制器
 * @Author wangzhihao
 * @Date 19/11/18 22:54
 * @Version 1.0
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User queryOne(@PathVariable("id") Integer id){
        return this.userService.queryOne(id);
    }

    @DeleteMapping("/user/{id}")
    public Integer deleteOne(@PathVariable("id") Integer id){
        return this.userService.deleteOne(id);
    }

    @PostMapping("/user")
    public Integer insertOne(User user){
        return this.userService.insertOne(user);
    }

    @PutMapping("/user")
    public User updateOne(User user){
        return this.userService.updateOne(user);
    }

    @GetMapping("/users")
    public List<User> queryAll(@RequestParam(value="username",required = false) String username,
                               @RequestParam(value="password",required = false) String password){
        return userService.queryAll(username,password);
    }
}
