package com.xuewuzhijing.springboot.system.mapper;

import com.xuewuzhijing.springboot.system.entity.Role_Permission;
import com.xuewuzhijing.springboot.system.entity.User;
import com.xuewuzhijing.springboot.system.entity.User_Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @ClassName UserMapper
 * @Description User接口层
 * @Author xuewuzhijing
 * @Date 19/11/18 22:14
 * @Version 1.0
 **/
@Mapper
public interface UserMapper{
    User login(@Param("username") String username,@Param("password") String password);
    User queryOneByUsername(@Param("username") String username);
    Integer deleteOne(@Param("id") Integer id);
    Integer insertOne(User user);
    Integer updateOne(User user);
    List<User> queryAll(@Param("username") String username,@Param("password") String password);
    Set<User_Role> queryRolesByUsername(@Param("username") String username);
    Set<Role_Permission> queryPermissionsByRoleName(@Param("rolename") String rolename);
}
