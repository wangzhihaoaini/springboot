package com.xuewuzhijing.springboot.system.controller;

import com.xuewuzhijing.springboot.system.exception.StudentException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyExceptionHandler
 * @Description TODO
 * @Author xuewuzhijing
 * @Date 19/11/1 21:45
 * @Version 1.0
 **/
@ControllerAdvice
public class MyExceptionHandler {

    //1.浏览器和客户端返回的都是json数据，怎么办？
//    @ExceptionHandler(StudentException.class)
//    @ResponseBody
//    public Map<String,Object> handlerException(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","用户不存在");
//        map.put("message",e.getMessage());
//        return map;
//    }

    //2.改进版  转发到BasicErrorController的error请求，这个请求是自适应的，可以根据浏览器或者是客户端相应不同
    @ExceptionHandler(StudentException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        map.put("code","用户不存在");
        map.put("message",e.getMessage());
        //Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        //传入自己的状态码，否则找不到对应状态码的错误视图
        request.setAttribute("javax.servlet.error.status_code",500);
        return "forward:/error";
    }
}
