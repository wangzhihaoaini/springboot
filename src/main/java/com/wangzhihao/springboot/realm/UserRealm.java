package com.wangzhihao.springboot.realm;

import com.wangzhihao.springboot.entity.User;
import com.wangzhihao.springboot.service.UserService;
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
 * @Description Shiro鉴权
 * @Author wangzhihao
 * @Date 2019/12/9 13:34
 * @Version 1.0
 **/
@Component
public class UserRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;

    /**
    *@Author wangzhihao
    *@Description  权限认证，即登录过后，每个身份不一定，对应的所能看的页面也不一样。
    *@Date 13:35 2019/12/9
    *@Param [principalCollection]
    *@return org.apache.shiro.authz.AuthorizationInfo
    **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username=(String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> permission=new HashSet<String>();
        permission.add("user:resource");
        info.setStringPermissions(permission);
        return info;
    }

    /**
    *@Author wangzhihao
    *@Description 身份认证。即登录通过账号和密码验证登陆人的身份信息。
    *@Date 13:35 2019/12/9
    *@Param [authenticationToken]
    *@return org.apache.shiro.authc.AuthenticationInfo
    **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String)authenticationToken.getPrincipal();
        String userpwd=new String((char[])authenticationToken.getCredentials());
        //根据用户名从数据库获取用户
        User user = userService.queryOneByUsername(username);
        if(user==null||!userpwd.equals(user.getPassword())){
            throw new AccountException("用户名或密码不正确");
        }
        return new SimpleAuthenticationInfo(username, user.getPassword(),getName());
    }
}
