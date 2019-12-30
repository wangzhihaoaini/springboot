package com.wangzhihao.springboot.system.service.impl;

import com.wangzhihao.springboot.system.entity.User;
import com.wangzhihao.springboot.system.service.RabbitMQService;
import org.springframework.amqp.core.*;
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
    @Autowired
    private AmqpAdmin amqpAdmin;

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

    /**
    *@Author wangzhihao
    *@Description 监听的队列一旦有消息就消费
    *@Date 21:27 19/12/11
    *@Param [user]
    *@return void
    **/
//    @RabbitListener(queues = {"wangzhihao.bbb"})
    @Override
    public void receive(User user) {
        System.out.println(user);
    }

//    @RabbitListener(queues = {"wangzhihao.bbb"})
    public void receiveMessage(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }

    /**
    *@Author wangzhihao
    *@Description
    *@Date 21:46 19/12/11
    *@Param [queueName]
    *@return void
    **/
    @Override
    public void createQueue(String queueName) {
        amqpAdmin.declareQueue(new Queue(queueName));
    }

    @Override
    public void createExchange(String exchangeName) {
        amqpAdmin.declareExchange(new DirectExchange(exchangeName));
    }

    /**
    *@Author wangzhihao
    *@Description destination 要绑定的队列  destinationType QUEUE EXCHANGE
    *@Date 22:48 19/12/11
    *@Param [destination, destinationType, exchange, routingKey]
    *@return void
    **/
    @Override
    public void createBinding(String destination, Binding.DestinationType destinationType,String exchange, String routingKey){
        amqpAdmin.removeBinding(new Binding(destination,destinationType,exchange,routingKey,null));
    }
}
