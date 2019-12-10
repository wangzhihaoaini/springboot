package com.wangzhihao.springboot.service;

import org.springframework.amqp.core.Message;

/**
 * @ClassName RabbitMQService
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/12/10 21:21
 * @Version 1.0
 **/
public interface RabbitMQService{
    void send(String exchange, String routeKey, Message message);
    void convertAndSend(String exchange,String routeKey,Object object);
    Object receiveAndConvert(String queueName);
    void sendFanout(String exchange,Object object);
}
