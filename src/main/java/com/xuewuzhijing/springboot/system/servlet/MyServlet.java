package com.xuewuzhijing.springboot.system.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyServlet
 * @Description TODO
 * @Author xuewuzhijing
 * @Date 19/11/4 22:23
 * @Version 1.0
 **/
public class MyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防中文乱码
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("Hi,自定义servlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
