package com.wangzhihao.springboot;

import com.wangzhihao.springboot.system.entity.User;
import com.wangzhihao.springboot.system.service.RabbitMQService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

import static org.springframework.amqp.core.Binding.DestinationType.QUEUE;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private RabbitMQService rabbitMQService;

    @Test
    public void direct() {
        User user = new User();
        user.setUsername("11111111111111111111111111111111111111111111");
        user.setPassword("111111aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        rabbitMQService.convertAndSend("directExchange","wangzhihao.bbb",user);
    }

    @Test
    public void createQueue(){
        rabbitMQService.createQueue("wangzhihao.zzz");
    }

    @Test
    public void createExchange(){
        rabbitMQService.createExchange("amqpAdminDirectExchange");
    }

    @Test
    public void createBinding(){
        rabbitMQService.createBinding("wangzhihao.zzz",QUEUE,"amqpAdminDirectExchange","wangzhihao.zzz");
    }

    @Test
    public void localDate(){
    }
}
