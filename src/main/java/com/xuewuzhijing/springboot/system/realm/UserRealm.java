package com.xuewuzhijing.springboot.system.realm;

import com.xuewuzhijing.springboot.system.entity.Role_Permission;
import com.xuewuzhijing.springboot.system.entity.User;
import com.xuewuzhijing.springboot.system.entity.User_Role;
import com.xuewuzhijing.springboot.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UserRealm
 * @Description User登录和授权
 * @Author xuewuzhijing
 * @Date 2019/12/9 13:34
 * @Version 1.0
 **/
@Component
public class UserRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;

    /**
    *@Author xuewuzhijing
    *@Description  权限认证，即登录过后，每个身份不一定，对应的所能看的页面也不一样。
    *@Date 13:35 2019/12/9
    *@Param [principalCollection]
    *@return org.apache.shiro.authz.AuthorizationInfo
    **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> permission=new HashSet<String>();
        //查询用户拥有的权限
        Set<User_Role> user_roles = userService.queryRolesByUsername(user.getUsername());
//        for(User_Role userRole:user_roles){
//            Set<Role_Permission> role_permissions = userService.queryPermissionsByRoleName(userRole.getRolename());
//            for(Role_Permission rolePermission: role_permissions){
//                permission.add(rolePermission.getPermissionName());
//            }
//        }
        info.setStringPermissions(permission);
        return info;
    }

    /**
    *@Author xuewuzhijing
    *@Description 身份认证。即登录通过账号和密码验证登陆人的身份信息。
    *@Date 13:35 2019/12/9
    *@Param [authenticationToken]
    *@return org.apache.shiro.authc.AuthenticationInfo
    **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //controller中UsernamePasswordToken传过来的用户名
        String username=(String)authenticationToken.getPrincipal();
        String userpwd=new String((char[])authenticationToken.getCredentials());
        //根据用户名从数据库获取用户
        User user = userService.queryOneByUsername(username);
        // 账号不存在
        if(user==null){
            throw new UnknownAccountException("用户名或密码不正确");
        }
        // 密码错误
        if(!userpwd.equals(user.getPassword())){
            throw new IncorrectCredentialsException("用户名或密码不正确");
        }
        // 账号锁定
        if(user.getStatus()==0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
