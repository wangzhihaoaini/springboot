package com.wangzhihao.springboot.service.impl;

import com.wangzhihao.springboot.service.RabbitMQService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName RabbitMQServiceImpl
 * @Description RabbitMQ Service层
 * @Author wangzhihao
 * @Date 19/12/10 21:22
 * @Version 1.0
 **/
@Service
public class RabbitMQServiceImpl implements RabbitMQService{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
    *@Author wangzhihao
    *@Description direct点对点 Message需要自己构造一个，定义消息体内容和消息头
    *@Date 21:32 19/12/10
    *@Param [exchange, routeKey, message]
    *@return void
    **/
    @Override
    public void send(String exchange, String routeKey, Message message) {
        
    }

    /**
    *@Author wangzhihao
    *@Description direct点对点 object默认当成消息体，只需要传入要发送的对象，自动默认序列化发送给rabbitmq队列
     *             RabbitTemplate中MessageConverter-->SimpleMessageConverter createMessage方法使用的是Java默认序列化
     *             因此需要替换成Jackson,在配置类中替换掉MessageConverter即可
     *             tips:如果存自定义对象，需要有无参构造，因为Jackson反序列化需要无参构造方法
    *@Date 21:33 19/12/10
    *@Param [exchange, routeKey, object]
    *@return void
    **/
    public void convertAndSend(String exchange, String routeKey, Object object){
        rabbitTemplate.convertAndSend(exchange,routeKey,object);
    }

    /**
    *@Author wangzhihao
    *@Description 消费消息,自动转换为原来的类型(getClass()),也可以强转
    *@Date 22:21 19/12/10
    *@Param [queueName]
    *@return java.lang.Object
    **/
    public Object receiveAndConvert(String queueName){
        return rabbitTemplate.receiveAndConvert(queueName);
    }

    /**
    *@Author wangzhihao
    *@Description 广播，只需要发送给交换器就可以
    *@Date 22:46 19/12/10
    *@Param [exchange]
    *@return void
    **/
    @Override
    public void sendFanout(String exchange,Object object) {
        rabbitTemplate.convertAndSend(exchange,"",object);
    }
}
