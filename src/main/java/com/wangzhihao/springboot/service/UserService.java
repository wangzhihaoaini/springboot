package com.wangzhihao.springboot.service;

import com.wangzhihao.springboot.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/11/18 22:48
 * @Version 1.0
 **/
public interface UserService{
    User login(String username,String password);
    User queryOneByUsername(String username);
    Integer deleteOne(Integer id);
    Integer insertOne(User user);
    User updateOne(User user);
    List<User> queryAll(String username,String password);
}
