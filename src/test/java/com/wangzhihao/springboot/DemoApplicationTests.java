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

    @Test
    public void hello(){
        System.out.println("hello world");
    }
}
