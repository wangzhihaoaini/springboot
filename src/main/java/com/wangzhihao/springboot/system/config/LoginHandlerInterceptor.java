package com.wangzhihao.springboot.system.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginHandlerIntercepter
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/10/23 21:11
 * @Version 1.0
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前,需要去mvc配置中注册拦截器，并注册放行url和拦截url
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("/login");
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
