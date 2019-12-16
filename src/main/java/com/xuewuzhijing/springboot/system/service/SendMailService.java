package com.xuewuzhijing.springboot.system.service;

/**
 * @ClassName SendMailService
 * @Description 发送邮件service层。定义了发送纯文本，含html标签，含附件，含图片的方法
 * @Author xuewuzhijing
 * @Date 19/11/24 15:08
 * @Version 1.0
 **/
public interface SendMailService{
    String send(String sender,String receiver,String title,String text);
    String sendHtml(String sender,String receiver,String subject, String content);
    String sendAttachment(String sender,String receiver,String subject, String content, String filePath);
    String sendPicture(String sender,String receiver,String subject, String content,
                       String picPath,String picId);
}
