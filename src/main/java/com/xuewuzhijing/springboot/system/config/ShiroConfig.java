package com.xuewuzhijing.springboot.system.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.xuewuzhijing.springboot.system.realm.UserRealm;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description Shiro配置类
 * @Author xuewuzhijing
 * @Date 2019/12/9 11:41
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig{
    @Autowired
    private UserRealm userRealm;

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        //未授权界面,通过webMvcConfigurer映射，不走controller
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/noRole");
        //登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/index");
        Map<String,String> filterChainDefinitionMap=new LinkedHashMap<String, String>();
        /*过滤链定义，从上向下顺序执行，一般将/**放在最为下边,这是一个坑呢，一不小心代码就不好使了*/
        /*anon:所有url都都可以匿名访问*/
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");
        filterChainDefinitionMap.put("/user/login", "anon");
        filterChainDefinitionMap.put("/user/register", "anon");
        filterChainDefinitionMap.put("/", "anon");

        /*authc:所有url都必须认证通过才可以访问,特殊页面如订单或者支付*/
        filterChainDefinitionMap.put("/resource/game1", "authc");
        /*需要授权才能访问*/
        filterChainDefinitionMap.put("/resource/**","perms[user:resource]");
        /*user:配置记住我或认证通过可以访问*/
        filterChainDefinitionMap.put("/resource/index", "user");
//        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
    *@Author xuewuzhijing
    *@Description 核心的安全事务管理器
    *@Date 13:43 2019/12/11
    *@Param []
    *@return org.apache.shiro.mgt.SecurityManager
    **/
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        //设置Realm，用于获取认证凭证
        defaultWebSecurityManager.setRealm(userRealm);
        //设置cookieRememberMeManager
        defaultWebSecurityManager.setRememberMeManager(cookieRememberMeManager());
        return defaultWebSecurityManager;
    }

    //开启对shior注解配置权限的支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
    *@Author xuewuzhijing
    *@Description 记住我cookie
    *@Date 13:42 2019/12/11
    *@Param []
    *@return org.apache.shiro.web.servlet.SimpleCookie
    **/
    @Bean
    public SimpleCookie rememberCookie(){
        SimpleCookie simpleCookie=new SimpleCookie("rememberMe");
        //30天
        simpleCookie.setMaxAge(60*60*24*30);
        //如果httyOnly设置为true，则客户端不会暴露给客户端脚本代码，使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击
        simpleCookie.setHttpOnly(true);
        // 设置路径
        simpleCookie.setPath("/");
        return simpleCookie;
    }

    /**
    *@Author xuewuzhijing
    *@Description cookie管理对象 rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
    *@Date 14:21 2019/12/11
    *@Param []
    *@return org.apache.shiro.web.mgt.CookieRememberMeManager
    **/
    @Bean
    public CookieRememberMeManager cookieRememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberCookie());
        //这个地方有点坑，不是所有的base64编码都可以用，长度过大过小都不行，
        //没搞明白，官网给出的要么0x开头十六进制，要么base64
        cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        return cookieRememberMeManager;
    }

    /**
    *@Author wangzhihao
    *@Description Thymeleaf和Shiro标签整合
    *@Date 11:34 2019/12/18
    *@Param []
    *@return at.pollux.thymeleaf.shiro.dialect.ShiroDialect
    **/
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}
