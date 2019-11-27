package com.wangzhihao.springboot.mapper;

import com.wangzhihao.springboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description User接口层
 * @Author wangzhihao
 * @Date 19/11/18 22:14
 * @Version 1.0
 **/
@Repository
public interface UserMapper{
    User queryOne(@Param("id") Integer id);
    Integer deleteOne(@Param("id") Integer id);
    Integer insertOne(User user);
    Integer updateOne(User user);
    List<User> queryAll(@Param("username") String username,@Param("password") String password);
}
