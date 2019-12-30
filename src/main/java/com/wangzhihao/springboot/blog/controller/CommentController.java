package com.wangzhihao.springboot.blog.controller;

import com.wangzhihao.springboot.blog.service.CommentService;
import com.wangzhihao.springboot.common.controller.BaseController;
import com.wangzhihao.springboot.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName CommentController
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/30 13:48
 * @Version 1.0
 **/
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController{
    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    @ResponseBody
    public Object addComment(@RequestParam("articleId") Integer articleId,
                             @RequestParam("comment") String comment){
        User user = this.getUser();
        if(user==null){
            return this.ajaxFail("请先登录");
        }
        try {
            commentService.addComment(articleId,comment,user.getNickName());
        }catch (Exception e){
            return this.ajaxFail("留言失败,原因为:"+e.getMessage());
        }
        return this.ajaxSuccess("留言成功");
    }
}
