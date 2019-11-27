package com.wangzhihao.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/10/23 20:45
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/loginIn")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request){
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            request.setAttribute("msg","用户名或密码不能为空");
            return "login";
        }else{
            if("admin".equals(username)&&"admin".equals(password)){
                request.getSession().setAttribute("user",username);
                return "redirect:/learn/index";
            }else{
                request.setAttribute("msg","用户名或密码错误");
                return "login";
            }
        }
    }
}
