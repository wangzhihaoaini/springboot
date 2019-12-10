package com.wangzhihao.springboot;

import com.wangzhihao.springboot.entity.User;
import com.wangzhihao.springboot.service.RabbitMQService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private RabbitMQService rabbitMQService;

    /**
    *@Author wangzhihao
    *@Description direct
    *@Date 21:24 19/12/10
    *@Param []
    *@return void
    **/
    @Test
    public void direct() {
        Map<String,Object> map=new HashMap<>();
        map.put("msg","helloworld");
        map.put("list", Arrays.asList("aaa",111,2.0));
        User user = new User();
        user.setUsername("wangzhihao");
        user.setPassword("wangzhihaoaaaaa");
        //        rabbitMQService.convertAndSend("directExchange","wangzhihao.bbb",map);
        rabbitMQService.convertAndSend("directExchange","wangzhihao.bbb",user);
    }

    /**
    *@Author wangzhihao
    *@Description 消费消息
    *@Date 22:20 19/12/10
    *@Param []
    *@return Object
    **/
    @Test
    public void receiveAndConvert(){
        Object object = rabbitMQService.receiveAndConvert("wangzhihao.bbb");
        System.out.println(object.getClass());
        System.out.println(object);
    }
}
