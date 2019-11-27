package com.wangzhihao.springboot.service.impl;

import com.wangzhihao.springboot.entity.User;
import com.wangzhihao.springboot.mapper.UserMapper;
import com.wangzhihao.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author wangzhihao
 * @Date 19/11/18 22:49
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    /**
    *@Author wangzhihao
    *@Description @Cacheable将返回值缓存，如果再次查询相同的结果，将不再访问数据库
     * CacheManager管理多个Cache组件  对缓存真正的操作在Cache组件中  每一个缓存都有自己的名字
     * 几个属性：
     *      cacheNames/value：指定缓存组件Cache的名字；
     *                   key：缓存数据时指定的key；如果不指定，默认使用方法参数的值
     *                        编写SpEL：#id,参数id的值  #a0 #p0 #root.args[0]
     *          keyGenerator：key的生成器  可以自己指定key的生成器的组件id   和key二选一
     *          cacheManager：指定缓存管理器；
     *             condition：指定符合条件时才缓存；  如 condition = "#id>0"
     *                unless：否定缓存，当unless指定的条件为true时，方法的返回值就不会缓存,
     *                        可以获取到结果进行判断 unless = "#result==null"  result为方法结果;
     *                  sync：是否使用异步
    *@Date 22:02 19/11/26
    *@Param [id]
    *@return com.wangzhihao.springboot.entity.User
    **/
    @Cacheable(cacheNames = "user")
    @Override
    public User queryOne(Integer id){
        return this.userMapper.queryOne(id);
    }

    @Override
    public Integer deleteOne(Integer id){
        return this.userMapper.deleteOne(id);
    }

    @Override
    public Integer insertOne(User user){
        return this.userMapper.insertOne(user);
    }

    @Override
    public Integer updateOne(User user){
        return this.userMapper.updateOne(user);
    }

    @Override
    public List<User> queryAll(String username, String password){
        return userMapper.queryAll(username,password);
    }
}
