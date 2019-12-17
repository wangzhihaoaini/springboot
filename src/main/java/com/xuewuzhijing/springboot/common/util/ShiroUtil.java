package com.xuewuzhijing.springboot.common.util;

import com.xuewuzhijing.springboot.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.List;

/**
 * @ClassName ShiroUtil
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/17 13:29
 * @Version 1.0
 **/
public class ShiroUtil{
    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static User getUser(){
        return (User)getSubject().getPrincipal();
    }

    public static Integer getUserId(){
        return getUser().getId();
    }

    public static void logout(){
        getSubject().logout();
    }

    public static List<Principal> getPrinciples(){
        List<Principal> principals = null;
        sessionDAO.getActiveSessions();
        return principals;
    }
}
