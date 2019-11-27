package com.wangzhihao.springboot.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName MyLocaleResolver
 * @Description 自定义的区域信息解析器，接受页面传的参数
 * @Author wangzhihao
 * @Date 19/10/22 21:44
 * @Version 1.0
 **/
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        //区域信息解析对象,如果前端页面没有参数，就用系统默认的
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
