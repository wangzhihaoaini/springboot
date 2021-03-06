package com.wangzhihao.springboot.common.controller;

import com.wangzhihao.springboot.common.entity.Result;
import com.wangzhihao.springboot.common.util.ShiroUtil;
import com.wangzhihao.springboot.system.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "基础控制器")
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
    @ApiOperation(value = "ajax成功")
    @ApiImplicitParam(name = "msg", value = "消息",  paramType = "path", required = true, dataType =  "String")
    public Object ajaxSuccess(String msg) {
        Result result = new Result();
        result.setSuccess(true);
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
        result.setObject(obj);
        return result;
    }

    /**
     * ajax成功
     * @param obj 成功时的消息和对象
     * @return {Object}
     */
    public Object ajaxSuccess(String msg,Object obj) {
        Result result = new Result();
        result.setMsg(msg);
        result.setSuccess(true);
        result.setObject(obj);
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

}
