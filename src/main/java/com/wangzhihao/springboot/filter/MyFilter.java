package com.wangzhihao.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/11/4 22:38
 * @Version 1.0
 **/
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器我进来了！");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
