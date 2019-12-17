package com.xuewuzhijing.springboot.system.controller;

import com.xuewuzhijing.springboot.common.controller.BaseController;
import com.xuewuzhijing.springboot.system.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SendMailController
 * @Description 发送邮件controller层
 * @Author xuewuzhijing
 * @Date 19/11/24 15:16
 * @Version 1.0
 **/
@Controller
@RequestMapping("/mail")
public class SendMailController extends BaseController{
    @Autowired
    private SendMailService sendMailService;

    @Value("${spring.mail.username}")
    private String sender;

    /**
    *@Author xuewuzhijing
    *@Description 发送纯文本的方法
    *@Date 15:30 19/11/24
    *@Param [receiver] 入参为接收者的邮箱地址
    *@return java.lang.String
    **/
    @GetMapping("/send")
    @ResponseBody
    public String send(@RequestParam("receiver") String receiver){
        String title="66万漏油奔驰";    //标题
        String text="【坐在引擎盖上哭】“　66万买辆奔驰,还没开出店门就漏油,请问这种车去哪里买呢,我也想要一辆。";
        return sendMailService.send(sender, receiver, title, text);
    }

    /**
    *@Author xuewuzhijing
    *@Description 发送纯文本的方法
    *@Date 16:04 19/11/24
    *@Param [receiver] 入参为接收者的邮箱地址
    *@return java.lang.String
    **/
    @GetMapping("/sendHtml")
    @ResponseBody
    public String sendHtml(@RequestParam("receiver") String receiver){
        String title="无标题";
        String content = "<html>\n"+
                "<body>\n"+
                "<h2>这是一封有历史意义的HTML邮件,请注意查收!!!</h2>\n"+
                "</body>\n"+
                "</html>";
        String html = sendMailService.sendHtml(sender,receiver,title,content);
        return html;
    }

    @GetMapping("/sendAttachment")
    @ResponseBody
    public String sendAttachment(@RequestParam("receiver") String receiver,@RequestParam("filePath") String filePath){
        String title="附件邮件";
//        String filePath = "E:\\IDEA使用方法\\yml知识.txt";
        String content = "我的这封邮件可是很厉害的,因为它可以带附件呦!!!";
        String attachment = sendMailService.sendAttachment(sender,receiver,title,content,filePath);
        return attachment;
    }

    @GetMapping("/sendPicture")
    @ResponseBody
    public String sendPicture(@RequestParam("receiver") String receiver,@RequestParam("picPath") String picPath){
        String title="图片邮件";
        String picId = "PIC001";
        String content = "<html><body>我的这封邮件可是很厉害的,因为它可以显示图片呦!!!\n" +
                "<img src=\'cid:"+picId+"\'></img></body></html>";
        String picture = sendMailService.sendPicture(sender,receiver,title,content,picPath,picId);
        return picture;
    }
}