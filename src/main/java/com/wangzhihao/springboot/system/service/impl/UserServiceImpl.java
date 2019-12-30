package com.wangzhihao.springboot.system.service.impl;

import com.wangzhihao.springboot.system.entity.Role_Permission;
import com.wangzhihao.springboot.system.entity.User;
import com.wangzhihao.springboot.system.entity.User_Role;
import com.wangzhihao.springboot.system.mapper.UserMapper;
import com.wangzhihao.springboot.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    *@return com.wangzhihao.springboot.system.entity.User
    **/
    @Override
    public User login(String username,String password){
        return this.userMapper.login(username,password);
    }

    @Override
    public User queryOneByUsername(String username) {
        return this.userMapper.queryOneByUsername(username);
    }


    /**
     *@Author wangzhihao
     *@Description @CacheEvict新出现两个属性allEntries 和beforeInvocation
     *
     *allEntries:allEntries是boolean类型，表示是否需要清除缓存中的所有元素。默认为false，
     *表示不需要。当指定了allEntries为true时，Spring Cache将忽略指定的key。有的时候我们需要
     *Cache一下清除所有的元素，这比一个一个清除元素更有效率。
     *
     * beforeInvocation:清除操作默认是在对应方法成功执行之后触发的，即方法如果因为抛出异常而未能
     * 成功返回时也不会触发清除操作。使用beforeInvocation可以改变触发清除操作的时间，当我们指定该
     * 属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。
     *@Date 13:54 19/11/28
     *@Param [id]
     *@return java.lang.Integer
     **/
    @CacheEvict(cacheNames = "user")
    @Override
    public Integer deleteOne(Integer id){
        return this.userMapper.deleteOne(id);
    }

    @Override
    public Integer insertOne(User user){
        return this.userMapper.insertOne(user);
    }

    /**
     *@Author wangzhihao
     *@Description @CachePut用于方法执行后，讲更新的结果存到缓存，既保证了方法的调用，又更新缓存
     *             ps:注意@CachePut更新后的key，要与Cacheable中的一致，否则无法更新缓存，会存入一个新的CachePut的key的缓存
     *@Date 9:34 19/11/28
     *@Param [user]
     *@return java.lang.Integer
     **/
    @CachePut(cacheNames = "user",key = "#user.id")
    @Override
    public User updateOne(User user){
        this.userMapper.updateOne(user);
        return user;
    }

    /**
     *@Author wangzhihao
     *@Description @Caching组合缓存注解
     *               适用于复杂缓存注解的方法，指定多种缓存策略
     *@Date 21:28 19/12/02
     *@Param [username,password]
     *@return User
     **/
    @Caching(
            cacheable = {
                    @Cacheable(value = "user",key = "#username")
            },
            put={
                    @CachePut(value = "user",key = "#password"),
                    @CachePut(value = "user",key = "#result.id")
            },
            evict = {
                    @CacheEvict(value = "user",key = "#username")
            }
    )
    @Override
    public List<User> queryAll(String username, String password){
        return userMapper.queryAll(username,password);
    }

    @Override
    public Set<User_Role> queryRolesByUsername(String username){
        return this.userMapper.queryRolesByUsername(username);
    }

    @Override
    public Set<Role_Permission> queryPermissionsByRoleName(String rolename) {
        return this.userMapper.queryPermissionsByRoleName(rolename);
    }
}
