package com.xuewuzhijing.springboot.common.controller;

import com.xuewuzhijing.springboot.common.entity.Result;
import com.xuewuzhijing.springboot.common.util.ShiroUtil;
import com.xuewuzhijing.springboot.system.entity.User;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * @ClassName BaseController
 * @Description 基础控制器
 * @Author wangzhihao
 * @Date 2019/12/17 13:26
 * @Version 1.0
 **/
@Controller
public class BaseController{
    protected Logger logger= LoggerFactory.getLogger(BaseController.class);

    public Subject getSubject(){
        return ShiroUtil.getSubject();
    }

    public User getUser(){
        return ShiroUtil.getUser();
    }

    public Integer getUserId(){
        return ShiroUtil.getUserId();
    }

    public String getUsername(){
        return ShiroUtil.getUser().getUsername();
    }

    public void logout(){
        ShiroUtil.logout();
    }

    /**
     * ajax成功
     * @param msg 消息
     * @return {Object}
     */
    public Object ajaxSuccess(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax失败
     * @param msg 消息
     * @return {Object}
     */
    public Object ajaxFail(String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax成功
     * @param obj 成功时的对象
     * @return {Object}
     */
    public Object ajaxSuccess(Object obj) {
        Result result = new Result();
        result.setSuccess(true);
        result.setObj(obj);
        return result;
    }


}
