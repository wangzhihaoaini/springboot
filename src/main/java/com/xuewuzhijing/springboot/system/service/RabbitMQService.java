package com.xuewuzhijing.springboot.system.service;

import com.xuewuzhijing.springboot.system.entity.User;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Message;

/**
 * @ClassName RabbitMQService
 * @Description TODO
 * @Author xuewuzhijing
 * @Date 19/12/10 21:21
 * @Version 1.0
 **/
public interface RabbitMQService{
    //以下方法为RabbitTemplate
    void send(String exchange, String routeKey, Message message);
    void convertAndSend(String exchange,String routeKey,Object object);
    Object receiveAndConvert(String queueName);
    void sendFanout(String exchange,Object object);
    void receive(User user);
    void receiveMessage(Message message);
    //以下方法为AmqpAdmin
    void createQueue(String queueName);
    void createExchange(String exchangeName);
    void createBinding(String destination, Binding.DestinationType destinationType,String exchange, String routingKey);
}
