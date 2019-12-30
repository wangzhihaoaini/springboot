package com.wangzhihao.springboot.system.service;

import com.wangzhihao.springboot.system.entity.Role_Permission;
import com.wangzhihao.springboot.system.entity.User;
import com.wangzhihao.springboot.system.entity.User_Role;

import java.util.List;
import java.util.Set;

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
    Set<User_Role> queryRolesByUsername(String username);
    Set<Role_Permission> queryPermissionsByRoleName(String rolename);
}
