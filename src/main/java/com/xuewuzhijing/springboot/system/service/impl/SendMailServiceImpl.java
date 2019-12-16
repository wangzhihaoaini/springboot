package com.xuewuzhijing.springboot.system.service.impl;

import com.xuewuzhijing.springboot.system.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName SendMailServiceImpl
 * @Description 发送邮件接口实现类
 * @Author xuewuzhijing
 * @Date 19/11/24 15:09
 * @Version 1.0
 **/
@Service
public class SendMailServiceImpl implements SendMailService{
    @Autowired
    private JavaMailSender javaMailSender;

    /**
    *@Author xuewuzhijing
    *@Description 发送纯文本的方法
    *@Date 16:01 19/11/24
    *@Param [sender, receiver, title, text]
    *@return java.lang.String
    **/
    @Override
    public String send(String sender, String receiver, String title, String text) {
        try {
            //建立邮件消息
            SimpleMailMessage mainMessage = new SimpleMailMessage();
            //发送方
            mainMessage.setFrom(sender);
            //接收方
            mainMessage.setTo(receiver);
            //发送的标题
            mainMessage.setSubject(title);
            //发送的内容
            mainMessage.setText(text);
            javaMailSender.send(mainMessage);
            return "send success";
        }catch (Exception e){
            return "send false";
        }
    }

    @Override
    public String sendHtml(String sender, String receiver, String subject, String content) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            //发送方
            helper.setFrom(sender);
            //接收方
            helper.setTo(receiver);
            //邮件主题
            helper.setSubject(subject);
            //邮件内容
            helper.setText(content,true);
            javaMailSender.send(message);
            return "sendHtml success";
        }catch (Exception e){
            return "sendHtml false";
        }
    }

    @Override
    public String sendAttachment(String sender, String receiver, String subject, String content, String filePath) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            //发送方
            helper.setFrom(sender);
            //接收方
            helper.setTo(receiver);
            //邮件主题
            helper.setSubject(subject);
            //邮件内容
            helper.setText(content,true);
            //邮件的附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            //获取附件的文件名
            String fileName = file.getFilename();
            helper.addAttachment(fileName,file);
            javaMailSender.send(message);
            return "sendAttachment success";
        }catch (Exception e){
            return "sendAttachment false";
        }
    }

    @Override
    public String sendPicture(String sender, String receiver, String subject, String content, String picPath, String picId) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            //发送方
            helper.setFrom(sender);
            //接收方
            helper.setTo(receiver);
            //邮件主题
            helper.setSubject(subject);
            //邮件内容
            helper.setText(content,true);
            //邮件的图片
            FileSystemResource file = new FileSystemResource(new File(picPath));
            helper.addInline(picId,file);
            javaMailSender.send(message);
            return "sendPicture success";
        }catch (Exception e){
            return "sendPicture false";
        }
    }
}
